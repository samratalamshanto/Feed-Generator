package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CertificateUpdateTest {

    @Test
    void testGetConversionTableValue() {
        char inputChar = 'E';
        int asciiValue = inputChar - 'A';
        int res = asciiValue + 10;
        assertEquals(14, res);
    }
}