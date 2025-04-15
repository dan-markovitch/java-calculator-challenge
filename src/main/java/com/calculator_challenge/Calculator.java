package com.calculator_challenge;

public class Calculator {
    private final InputProcessor processor;
    private final NumberCalculator numberCalculator;

    public Calculator() {
        this.processor = new InputProcessor();
        this.numberCalculator = new NumberCalculator();
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        String numbersPart = input;

        // Check for single-character custom delimiter
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex != -1 && newlineIndex > 2) {
                delimiter = input.substring(2, newlineIndex);
                numbersPart = input.substring(newlineIndex + 1);
            }
        }

        String[] numbers = numbersPart.split(delimiter);
        StringBuilder negatives = new StringBuilder();
        var parsedNumbers = processor.parseNumbers(numbers, negatives);

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return numberCalculator.sumNumbers(parsedNumbers);
    }
}