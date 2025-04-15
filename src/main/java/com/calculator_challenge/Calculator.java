package com.calculator_challenge;

public class Calculator {
    private final InputProcessor processor = new InputProcessor();
    private final NumberCalculator numberCalculator = new NumberCalculator();

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        var numbers = input.split(",");
        if (numbers.length > 2) {
            throw new IllegalArgumentException("Cannot add more than 2 numbers");
        }
        var negatives = new StringBuilder();
        var parsedNumbers = processor.parseNumbers(numbers, negatives);
        if (negatives.length() > 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negatives);
        }
        return numberCalculator.sumNumbers(parsedNumbers);
    }
}