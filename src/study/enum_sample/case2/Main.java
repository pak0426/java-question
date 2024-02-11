package study.enum_sample.case2;

import static study.enum_sample.case2.Calculator.*;

public class Main {
    public static void main(String args[]) {
        Table table1 = new Table("A");
        String str = table1.getData();
        long value = 5L;
        long result = start(str, value);
        System.out.println("result = " + result);

        CalculatorEnum calA = CalculatorEnum.CAL_A;
        System.out.println("result2 = " + calA.calculate(value));

        CalculatorEnum calB = CalculatorEnum.CAL_B;
        System.out.println("result3 = " + calB.calculate(value));
    }
}