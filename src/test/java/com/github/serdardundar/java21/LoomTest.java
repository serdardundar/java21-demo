package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LoomTest {

    static void handleRequest(Socket socket) throws Exception {
        var next = -1;
        try (var baos = new ByteArrayOutputStream()) {
            try (var in = socket.getInputStream()) {
                while ((next = in.read()) != -1) {
                    baos.write(next);
                }
            }
            var inputMessage = baos.toString();
            System.out.printf("request: %s", inputMessage);
        }
    }

    public static void main(String[] args) {
        var executor = Executors.newVirtualThreadPerTaskExecutor();

        try (var serverSocket = new ServerSocket(9090)) {
            while (true) {
                var clientSocket = serverSocket.accept();
                executor.submit(() -> {
                    try {
                        handleRequest(clientSocket);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void loom() throws Exception {
        var observed = new ConcurrentSkipListSet<String>();
        var threads = IntStream
            .range(0, 100)
            .mapToObj(index -> Thread.ofVirtual()
                .unstarted(() -> {
                    var first = index == 0;
                    if(first) {
                        observed.add(Thread.currentThread().toString());
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(first) {
                        observed.add(Thread.currentThread().toString());
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(first) {
                        observed.add(Thread.currentThread().toString());
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(first) {
                        observed.add(Thread.currentThread().toString());
                    }
                }))
            .toList();

        for (var t : threads) {
            t.start();
        }

        for (var t : threads) {
            t.join();
        }

        System.out.println(observed);
        assertTrue(observed.size() > 1);
    }
}
