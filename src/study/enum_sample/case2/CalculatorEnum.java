package study.enum_sample.case2;

import java.util.function.Function;

public enum CalculatorEnum {
    CAL_A(value -> value * 3),
    CAL_B(value -> value * 10);

    private Function<Long, Long> expression;

    CalculatorEnum(Function<Long, Long> expression) {
        this.expression = expression;
    }

    public long calculate(long value) {
        return expression.apply(value);
    }
}
