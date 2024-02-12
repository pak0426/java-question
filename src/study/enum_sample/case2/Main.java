package study.enum_sample.case2;

public class Main {
public static void main(String args[]) {
    Table table1 = new Table("A");
    String str = table1.getData();
    long value = 5L;
    long result = Calculator.start(str, value);
    System.out.println("result = " + result);

    long value2 = 13L;
    CalculatorEnum calA = getCalA();
    System.out.println("result2 = " + calA.calculate(value2));

    CalculatorEnum calB = getCalB();
    System.out.println("result3 = " + calB.calculate(value2));
}

    public static CalculatorEnum getCalA() {
        return CalculatorEnum.CAL_A;
    }

    public static CalculatorEnum getCalB() {
        return CalculatorEnum.CAL_B;
    }
}