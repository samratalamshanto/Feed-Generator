package com.solvians.showcase.util;

import java.util.Random;

public final class AppUtil {

    private AppUtil() {
    }

    public static int getConversionValue(char inputChar) {
        //A = 10 -> (char's ascii Value - A's ascii value  ) + 10 = 0+10
        //B = 11 -> (char's ascii Value - A's ascii value  ) + 10 = 1+10
        int asciiValue = inputChar - 'A';
        return asciiValue + 10;
    }

    public static int getRandomValueInclusive(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

}
