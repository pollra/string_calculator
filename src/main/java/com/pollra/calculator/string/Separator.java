package com.pollra.calculator.string;

public interface Separator {



    interface SyntaxParser {
        static String toSyntaxString(String expression) {
            return null;
        }
    }

    interface ArrayParser {
        static int[] toIntegerArray(String expression) {
            return new int[0];
        }
    }

}
