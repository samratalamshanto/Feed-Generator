package com.solvians.showcase.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class CertificateUpdateUtil {
    private CertificateUpdateUtil() {
    }

    //provided table in readme, can store into map too which stores unnecessary in the heap memory.
    public static int getConversionTableValue(char inputChar) {
        //A = 10 -> (char's ascii Value - A's ascii value  ) + 10 = 0+10
        //B = 11 -> (char's ascii Value - A's ascii value  ) + 10 = 1+10
        int asciiValue = inputChar - 'A';
        return asciiValue + 10;
    }

    public static int getRandomIntegerInclusive(int min, int max) {
        return ThreadLocalRandom.current().nextInt(max + 1 - min) + min;
    }

    public static Double getRandomDoubleInclusive(double min, double max) {
        double value = ThreadLocalRandom.current().nextDouble(min, max + 0.01);
        return Math.round(value * 100.0) / 100.0; // round to 2 decimal
    }


    public static synchronized String generateISIN() {
        StringBuilder stringBuilder = new StringBuilder();

        //first 2 char --> ASCII (65-90) [A-Z]
        for (int i = 0; i < 2; i++) {
            char ch = (char) CertificateUpdateUtil.getRandomIntegerInclusive(65, 90);
            stringBuilder.append(ch);
        }

        //random int--> 0-9
        for (int i = 0; i < 9; i++) {
            stringBuilder.append(CertificateUpdateUtil.getRandomIntegerInclusive(0, 9));
        }

        //checkSum
        stringBuilder.append(calculateChecksum(stringBuilder.toString()));

        return stringBuilder.toString();
    }

    public static int calculateChecksum(String isin) {
        for (int i = 0; i < 3; i++) {  //char found in the range of max 3 digits
            char ch = isin.charAt(i);
            if (ch >= '0' && ch <= '9') {
                continue;
            }
            int tableValue = CertificateUpdateUtil.getConversionTableValue(ch);
            StringBuilder stringBuilder = new StringBuilder(tableValue);

            //replace with conversionTableValue in reverseOrder
            isin = isin.replace(String.valueOf(ch), stringBuilder.reverse().toString());
        }

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = isin.length() - 1; i >= 0; i--) {
            char ch = isin.charAt(i);
            int numValue = Character.getNumericValue(ch);
            list.add(10 * numValue);
            if (i % 2 != 0) {
                sum += (2 * numValue);
            } else {
                sum += numValue;
            }
        }

        list = list.stream().sorted().collect(Collectors.toList());
        for (Integer singleNum : list) {
            if (singleNum == sum) {
                return 0;
            } else if (singleNum > sum) {
                return singleNum - sum;
            }
        }

        return 0;
    }

}
