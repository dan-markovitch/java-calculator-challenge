package com.calculator_challenge;

import java.util.List;

public class NumberCalculator {
    public int sumNumbers(List<Integer> numbers) {
        var sum = 0;
        for (var value : numbers) {
            sum += value;
        }
        return sum;
    }
}