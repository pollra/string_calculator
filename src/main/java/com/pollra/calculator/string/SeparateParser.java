package com.pollra.calculator.string;

public class SeparateParser implements Separator.SyntaxParser{

    private final static String PREV_SEPARATOR = "//";
    private final static String SUB_SEPARATOR  = "\n";

    public static String toSyntaxString(String expression) {
        String separator = expression.substring(
                  expression.indexOf(PREV_SEPARATOR) + PREV_SEPARATOR.length()
                , expression.indexOf(SUB_SEPARATOR));
        return separator;
    }
}
