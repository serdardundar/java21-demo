package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class MultilineStringTest {

    @Test
    void multilineString() {
        var multiStr = """
                this is a multiline string
                    indent is applicable
            the last line.
            """;

        assertNotEquals('t', multiStr.charAt(0));
        multiStr = multiStr.stripLeading();
        assertEquals('t', multiStr.charAt(0));
    }
}
