package com.calculator_challenge;

public class Calculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split("[,\n]");
        int sum = 0;
        StringBuilder negatives = new StringBuilder();
        for (String num : numbers) {
            try {
                int value = Integer.parseInt(num.trim());
                if (value < 0) {
                    if (negatives.length() > 0) {
                        negatives.append(", ");
                    }
                    negatives.append(value);
                } else {
                    sum += value;
                }
            } catch (NumberFormatException e) {
                sum += 0;
            }
        }
        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
        return sum;
    }
}