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

        String[] numbers = input.split("[,\n]");
        StringBuilder negatives = new StringBuilder();
        var parsedNumbers = processor.parseNumbers(numbers, negatives);

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }

        return numberCalculator.sumNumbers(parsedNumbers);
    }
}