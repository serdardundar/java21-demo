package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpTest {

    @Test
    void http() throws Exception {

        try (var http = HttpClient.newHttpClient()) {
            var request = HttpRequest.newBuilder(URI.create("https://www.adobe.com"))
                .GET()
                .build();
            var response = http.send(request, HttpResponse.BodyHandlers.ofString());
            assertEquals(200, response.statusCode());
            System.out.println(response.body());
        }
    }
}
