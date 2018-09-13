package com.cnqisoft.demo.util;

import java.util.Random;

public class PhoneValidCode {

    private static char[] code = {'0', '1', '2', '3' ,'4', '5', '6', '7', '8', '9'};

    private static final int SIZE = 6;
    public static String generateCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SIZE; ++i) {
            char c = code[random.nextInt(10)];
            sb.append(c);
        }
        return sb.toString();
    }
}
