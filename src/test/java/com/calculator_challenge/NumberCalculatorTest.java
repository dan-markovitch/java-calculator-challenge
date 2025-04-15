package com.calculator_challenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class NumberCalculatorTest {
    private final NumberCalculator calculator = new NumberCalculator();

    @Test
    void sumNumbersEmptyListReturnsZero() {
        assertEquals(0, calculator.sumNumbers(List.of()));
    }

    @Test
    void sumNumbersSingleNumberReturnsNumber() {
        assertEquals(20, calculator.sumNumbers(List.of(20)));
    }

    @Test
    void sumNumbersTwoNumbersReturnsSum() {
        assertEquals(5001, calculator.sumNumbers(List.of(1, 5000)));
    }
}