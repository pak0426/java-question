package study.테스트케이스.bdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @DisplayName("더하기 테스트")
    @Test
    public void addTest() {
        int result = Calculator.add(3, 5);
        Assertions.assertEquals(8, result);
    }
}