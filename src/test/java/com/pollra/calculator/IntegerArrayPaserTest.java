package com.pollra.calculator;

import com.pollra.calculator.string.IntegerArrayPaser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerArrayPaserTest {

    @Test
    public void 정상적인_String식이_들어왔을_때_int배열로_리턴함() {
        // arrange : 객체 선언
        final int[] answer = { 1, 2, 3, 4 };
        final String expression = "1:2,3:4";
        // act : 행동
        final int[] result = IntegerArrayPaser.toIntegerArray(expression);
        // assert : 원하는 결과
        assertArrayEquals(result, answer);
    }

    @Test
    public void 비정상적인_String식이_들어왔을_때_NumberFormetException_발생() {
        // arrange : 객체 선언
        final int[] answer = { 1, 2, 3, 4 };
        final String expression = "1:2,3:A";

        assertThrows(
                NumberFormatException.class                  // assert : 원하는 결과
                , () -> IntegerArrayPaser.toIntegerArray(expression) // act    : 행동
        );
    }

    @Test
    public void 음수가_포함된_String식이_들어왔을_때_RuntimeException_발생() {
        // arrange : 객체 선언
        final int[] answer = { -1, 2, 3, 4 };
        final String expression = "-1:2,3:4";

        assertThrows(
                RuntimeException.class                       // assert : 원하는 결과
                , () -> IntegerArrayPaser.toIntegerArray(expression) // act    : 행동
        );
    }

    @Test
    public void 커스텀_구분자를_사용한_정상적인_String식이_들어왔을_때_int배열로_리턴함() {
        // arrange : 객체 선언
        final int[] answer = { 1, 2, 3, 4 };
        final String expression = "//?\n1:2,3:4";
        // act : 행동
        final int[] result = IntegerArrayPaser.toIntegerArray(expression);
        // assert : 원하는 결과
        assertArrayEquals(result, answer);
    }
}
