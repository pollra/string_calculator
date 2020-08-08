package com.pollra.calculator;

import com.pollra.calculator.string.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setup(){
        stringCalculator = new StringCalculator();
    }

    @Test
    public void 커스텀구분자X_정상적인_String식이_넘어왔을때_결과리턴(){
        // arrange : 객체 선언
        final String expression = "1:2,3:4";
        final int answer = 10;
        // act : 행동
        final int result = stringCalculator.add(expression);
        // assert : 원하는 결과
        assertEquals(result, answer);
    }

    @Test
    public void 커스텀구분자X_비정상적인_String식이_넘어왔을때_NumberFormetException_발생() {
        // arrange : 객체 선언
        final String expression = "1:2,3:A";
        
        assertThrows(
                NumberFormatException.class              // assert : 원하는 결과
                , () -> stringCalculator.add(expression) // act    : 행동
        );
    }

    @Test
    public void 커스텀구분자O_정상적인_String식이_넘어왔을때_결과리턴(){
        // arrange : 객체 선언
        final String expression = "//?\n1:2,3?4";
        final int answer = 10;
        // act : 행동
        final int result = stringCalculator.add(expression);
        // assert : 원하는 결과
        assertEquals(result, answer);
    }
}
