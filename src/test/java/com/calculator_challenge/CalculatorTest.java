package com.calculator_challenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addEmptyInputReturnsZero() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void addNullInputReturnsZero() {
        assertEquals(0, calculator.add(null));
    }

    @Test
    void addSingleNumberReturnsNumber() {
        assertEquals(20, calculator.add("20"));
    }

    @Test
    void addTwoNumbersReturnsSum() {
        assertEquals(5001, calculator.add("1,5000"));
    }

    @Test
    void addNegativeNumbersThrowsException() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.add("4,-3"));
        assertEquals("Negative numbers not allowed: -3", exception.getMessage());
    }

    @Test
    void addInvalidNumberReturnsValidSum() {
        assertEquals(5, calculator.add("5,tytyt"));
    }

    @Test
    void addCommaOnlyReturnsZero() {
        assertEquals(0, calculator.add(","));
    }

    @Test
    void addMoreThanTwoNumbersThrowsException() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.add("1,2,3"));
        assertEquals("Cannot add more than 2 numbers", exception.getMessage());
    }
}