package com.calculator_challenge;

import java.util.ArrayList;
import java.util.regex.Pattern;

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

        // Check for custom delimiter
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex != -1) {
                String delimiterPart = input.substring(2, newlineIndex);
                if (delimiterPart.startsWith("[")) {
                    var delimiters = new ArrayList<String>();
                    int start = 0;
                    while (start < delimiterPart.length()) {
                        if (delimiterPart.charAt(start) != '[') break;
                        int end = delimiterPart.indexOf(']', start + 1);
                        if (end == -1) break;
                        delimiters.add(Pattern.quote(delimiterPart.substring(start + 1, end)));
                        start = end + 1;
                    }
                    if (!delimiters.isEmpty()) {
                        delimiter = String.join("|", delimiters);
                    }
                } else {
                    delimiter = Pattern.quote(delimiterPart);
                }
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