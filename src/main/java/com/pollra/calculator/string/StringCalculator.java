package com.pollra.calculator.string;

import java.util.Arrays;

public class StringCalculator {
    public int add(String text) {
        return Arrays.stream(IntegerArrayPaser.toIntegerArray(text))
                .sum();
    }
}
