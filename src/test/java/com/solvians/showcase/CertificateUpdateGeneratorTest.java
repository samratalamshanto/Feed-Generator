package com.solvians.showcase;

import com.solvians.showcase.util.AppUtil;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CertificateUpdateGeneratorTest {

    @Test
    public void generateQuotes() {
        CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(10, 100);
        Stream<CertificateUpdate> quotes = certificateUpdateGenerator.generateQuotes();
        assertNotNull(quotes);
        assertEquals(10 * 100, quotes.count());
    }

    @Test
    public void generateISIN() {
        CertificateUpdate certificateUpdate = new CertificateUpdate();
        System.out.println(certificateUpdate.generateISIN());

    }

    @Test
    public void generateISIN2() {
        String isin = "EQ2366618350";
        for (int i = 0; i < isin.length(); i++) {
            char ch = isin.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            }
            int tableValue = AppUtil.getConversionValue(ch);
            isin = isin.replace(String.valueOf(ch), String.valueOf(tableValue));
        }
        System.out.println(isin);
    }

}