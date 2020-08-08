package com.pollra.calculator.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerArrayPaser implements Separator.ArrayParser{

    private static List<String> separateStrings = new ArrayList<>();
    static {
        separateStrings.add(":");
        separateStrings.add(",");
    }


    public static int[] toIntegerArray(String expression) {
        try {
            return conversion(expression);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("식을 다시 확인 해 주세요");
        } catch (RuntimeException e) {
            throw new RuntimeException("음수는 계산하지 않습니다");
        }
    }

    private static int[] conversion(String expression){
        int[] result = Arrays.asList(
                replace(expression).split(","))
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < result.length; i++) {
            if(result[i] < 0)
                throw new RuntimeException();
        }
        return result;
    }

    private static String replace(String text) {
        for (String separator : separateStrings) {
            text = text.replace(separator, ",");
        }
        return text;
    }
}
