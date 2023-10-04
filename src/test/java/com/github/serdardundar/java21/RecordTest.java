package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RecordTest {

    record JavaVersion(String name) {}

    @Test
    void records() throws Exception {

        var version = new JavaVersion("Java21");
        assertEquals("Java21", version.name);
        System.out.println(version);
    }
}
