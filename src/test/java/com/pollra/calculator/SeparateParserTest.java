package com.pollra.calculator;

import com.pollra.calculator.string.SeparateParser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeparateParserTest {
    @Test
    public void 정상적인_syntax가_들어왔을_때_separateString을_리턴(){
        // arrange : 객체 선언
        final String expression = "//??\n1,2,3:4";
        final String answer = "??";

        // act : 행동
        final String result = SeparateParser.toSyntaxString(expression);
        // assert : 원하는 결과
        assertEquals(result, answer);
    }
}
