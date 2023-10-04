package com.github.serdardundar.java21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

class EnhancedSwitchTest {

    @Test
    void timeoff() throws Exception{
        assertEquals(16, calculateTimeOff(DayOfWeek.FRIDAY));
        assertEquals(24, calculateTimeOff(DayOfWeek.SATURDAY));
    }

    int calculateTimeOff(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 16;
            case SATURDAY, SUNDAY -> 24;
        };
    }
}
