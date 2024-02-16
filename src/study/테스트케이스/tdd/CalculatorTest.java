package study.테스트케이스.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @DisplayName("더하기 테스트")
    @Test
    public void addTest() {
        // given
        int a = 3;
        int b = 5;

        // when
        int result = Calculator.add(a, b);

        // then
        Assertions.assertEquals(8, result);
    }
}