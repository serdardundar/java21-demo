package com.github.serdardundar.java21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class MathsTest {

    @Test
    void divisions() {
        var five = Math.divideExact(10, 2);
        Assertions.assertEquals(5, five);
    }

    @Test
    void multiplication() {
        var start = BigInteger.valueOf(10);
        var result = start.parallelMultiply(BigInteger.TWO);
        Assertions.assertEquals(BigInteger.valueOf(10*2), result);
    }
}
