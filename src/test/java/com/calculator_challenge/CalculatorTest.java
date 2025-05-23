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
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    void addNegativeNumbersThrowsException() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.add("4,-3"));
        assertEquals("Negative numbers not allowed: -3", exception.getMessage());
    }

    @Test
    void addMultipleNegativesThrowsException() {
        var exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.add("1,-2,-3"));
        assertEquals("Negative numbers not allowed: -2, -3", exception.getMessage());
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

    @Test
    void addNewlineDelimiterReturnsSum() {
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void addMixedDelimitersReturnsSum() {
        assertEquals(10, calculator.add("1\n2\n3,4"));
    }

    @Test
    void addNumberGreaterThan1000ReturnsSumExcludingLarge() {
        assertEquals(8, calculator.add("2,1001,6"));
    }

    @Test
    void addMultipleLargeNumbersReturnsSumExcludingLarge() {
        assertEquals(2, calculator.add("2,1001,1002"));
    }

    @Test
    void addCustomDelimiterReturnsSum() {
        assertEquals(7, calculator.add("//#\n2#5"));
    }

    @Test
    void addCustomDelimiterWithInvalidAndValidNumbersReturnsSum() {
        assertEquals(102, calculator.add("//,\n2,ff,100"));
    }

    @Test
    void addMultiCharDelimiterReturnsSum() {
        assertEquals(66, calculator.add("//[***]\n11***22***33"));
    }

    @Test
    void addMultipleDelimitersReturnsSum() {
        assertEquals(110, calculator.add("//[*][!!][r9r]\n11r9r22*hh*33!!44"));
    }
}