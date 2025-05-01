package com.solvians.showcase;

import com.solvians.showcase.util.AppUtil;

import java.time.LocalDate;

public class CertificateUpdate {
    private Long timestamp = System.currentTimeMillis();
    private String isin = generateISIN();
    private Double bidPrice;
    private int bidSize;
    private Double askPrice;
    private int askSize;
    private LocalDate maturityDate;

    public CertificateUpdate() {
    }


    public CertificateUpdate(Long timestamp, String isin, Double bidPrice, int bidSize, Double askPrice, int askSize, LocalDate maturityDate) {
        this.timestamp = timestamp;
        this.isin = isin;
        this.bidPrice = bidPrice;
        this.bidSize = bidSize;
        this.askPrice = askPrice;
        this.askSize = askSize;
        this.maturityDate = maturityDate;
    }


    public String generateISIN() {
        StringBuilder stringBuilder = new StringBuilder();

        //first 2 char --> Asccii (65-90) [A-Z]
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            int randomInt = AppUtil.getRandomValueInclusive(65, 90);
            sum += randomInt;
            char ch = (char) randomInt;
            stringBuilder.append(ch);
        }

        //random int--> 0-9
        for (int i = 0; i < 9; i++) {
            int randomInt = AppUtil.getRandomValueInclusive(0, 9);
            sum += randomInt;
            stringBuilder.append(randomInt);
        }

        //checkSum
        stringBuilder.append(calculateChecksum(stringBuilder.toString()));

        return stringBuilder.toString();
    }

    public int calculateChecksum(String isin) {
        for (int i = 0; i < isin.length(); i++) {
            char ch = isin.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            }
            int tableValue = AppUtil.getConversionValue(ch);
            isin = isin.replace(String.valueOf(ch), String.valueOf(tableValue));
        }
        return 0;
    }
}
