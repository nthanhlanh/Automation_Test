package com.example.java_automation_framework.untils;

import java.security.SecureRandom;

public class RandomUtils {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETTERS_AND_DIGITS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomProjectKey(int length) {
        if (length < 2) {
            throw new IllegalArgumentException("Project key must be at least 2 characters long");
        }
        char firstChar = LETTERS.charAt(RANDOM.nextInt(LETTERS.length()));
        StringBuilder sb = new StringBuilder(length);
        sb.append(firstChar);
        for (int i = 1; i < length; i++) {
            sb.append(LETTERS_AND_DIGITS.charAt(RANDOM.nextInt(LETTERS_AND_DIGITS.length())));
        }

        return sb.toString();
    }
}