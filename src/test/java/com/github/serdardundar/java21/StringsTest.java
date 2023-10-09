package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class StringsTest {
    @Test
    void repeat() throws Exception {
        var line = new StringBuilder()
            .repeat("-", 10).toString();

        assertEquals("----------", line);
    }

    @Test
    void emojis() throws Exception {
        var shockedFaceEmoji = "\uD83E\uDD2F";
        var cp = Character.codePointAt(shockedFaceEmoji.toCharArray(), 0);
        assertTrue(Character.isEmoji(cp));
        System.out.println(shockedFaceEmoji);
    }


}
