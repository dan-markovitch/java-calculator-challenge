package com.calculator_challenge;

public class Calculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = input.split(",");
        int sum = 0;
        for (String num : numbers) {
            try {
                sum += Integer.parseInt(num.trim());
            } catch (NumberFormatException e) {
                sum += 0;
            }
        }
        return sum;
    }
}