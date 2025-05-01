package com.solvians.showcase;

import com.solvians.showcase.util.AppUtil;
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

    @Test
    public void generateISIN() {
        CertificateUpdate certificateUpdate = new CertificateUpdate();
        System.out.println(certificateUpdate.generateISIN());

    }

    @Test
    public void replaceWithConversionTable() {
        String isin = "EQ2366618350";
        for (int i = 0; i < isin.length(); i++) {
            char ch = isin.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            }
            int tableValue = AppUtil.getConversionValue(ch);
            isin = isin.replace(String.valueOf(ch), String.valueOf(tableValue));
        }
        assertEquals("14262366618350", isin);
    }
}