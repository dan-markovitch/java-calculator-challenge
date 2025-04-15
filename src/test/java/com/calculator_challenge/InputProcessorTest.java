package com.calculator_challenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class InputProcessorTest {
    private final InputProcessor processor = new InputProcessor();

    @Test
    void parseNumbersEmptyArrayReturnsEmptyList() {
        var negatives = new StringBuilder();
        assertTrue(processor.parseNumbers(new String[]{}, negatives).isEmpty());
    }

    @Test
    void parseNumbersSingleNumberReturnsList() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"20"}, negatives);
        assertEquals(List.of(20), result);
    }

    @Test
    void parseNumbersTwoNumbersReturnsList() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"1", "5000"}, negatives);
        assertEquals(List.of(1, 0), result); // Updated for >1000 rule
    }

    @Test
    void parseNumbersNegativeNumberAppendsToNegatives() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"4", "-3"}, negatives);
        assertEquals(List.of(4), result);
        assertEquals("-3", negatives.toString());
    }

    @Test
    void parseNumbersMultipleNegativesAppendsToNegatives() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"1", "-2", "-3"}, negatives);
        assertEquals(List.of(1), result);
        assertEquals("-2, -3", negatives.toString());
    }

    @Test
    void parseNumbersInvalidNumberReturnsZero() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"5", "tytyt"}, negatives);
        assertEquals(List.of(5, 0), result);
    }

    @Test
    void parseNumbersMultipleNumbersReturnsList() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"1", "2", "3"}, negatives);
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void parseNumbersLargeNumberInMultipleNumbersReturnsZero() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"2", "1001", "6"}, negatives);
        assertEquals(List.of(2, 0, 6), result);
    }

    @Test
    void parseNumbersMixedLargeAndValidInMultipleNumbersReturnsList() {
        var negatives = new StringBuilder();
        var result = processor.parseNumbers(new String[]{"2", "1001", "1002"}, negatives);
        assertEquals(List.of(2, 0, 0), result);
    }
}