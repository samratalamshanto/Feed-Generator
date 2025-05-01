package com.solvians.showcase;

import com.solvians.showcase.util.CertificateUpdateUtil;
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
        System.out.println(CertificateUpdateUtil.generateISIN());
    }

    @Test
    public void replaceWithConversionTable() {
        String isin = "EQ2366618350";
        for (int i = 0; i < 3; i++) {
            char ch = isin.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            }
            int tableValue = CertificateUpdateUtil.getConversionTableValue(ch);
            isin = isin.replace(String.valueOf(ch), String.valueOf(tableValue));
        }
        assertEquals("14262366618350", isin);
    }


    @Test
    public void testCalculateChecksum() {
        assertEquals(6, CertificateUpdateUtil.calculateChecksum("DE123456789"));
    }

    @Test
    public void testCallableClass() {
        CertificateUpdate certificateUpdate = new CertificateUpdate(1352122280502l, "DE1234567896", 101.23, 1000, 103.45, 1000);
        System.out.println(certificateUpdate);
    }
}


// “13 14 1 2 3 4 5 6 7 8 9”
//“2 3 2 4 2 2 6 4 10 6 14 8 18”.