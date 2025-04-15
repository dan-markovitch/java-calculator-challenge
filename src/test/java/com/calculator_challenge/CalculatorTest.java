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
    void addNegativeNumbersReturnsSum() {
        assertEquals(1, calculator.add("4,-3"));
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
    void addMultipleNumbersReturnsSum() {
        assertEquals(78, calculator.add("1,2,3,4,5,6,7,8,9,10,11,12"));
    }

    @Test
    void addThreeNumbersReturnsSum() {
        assertEquals(6, calculator.add("1,2,3"));
    }
}