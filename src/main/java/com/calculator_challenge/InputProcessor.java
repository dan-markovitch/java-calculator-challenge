package com.calculator_challenge;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {
    public List<Integer> parseNumbers(String[] numbers, StringBuilder negatives) {
        var parsed = new ArrayList<Integer>();
        for (var num : numbers) {
            try {
                var value = Integer.parseInt(num.trim());
                if (value < 0) {
                    if (negatives.length() > 0) {
                        negatives.append(", ");
                    }
                    negatives.append(value);
                } else if (value > 1000) {
                    parsed.add(0);
                } else {
                    parsed.add(value);
                }
            } catch (NumberFormatException e) {
                parsed.add(0);
            }
        }
        return parsed;
    }
}