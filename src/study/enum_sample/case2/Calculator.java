package study.enum_sample.case2;

public class Calculator {
    public static long start(String str, long value) {
        if (str.equals("A")) {
            return value * 2;
        }
        else if (str.equals("B")) {
            return value - 10;
        }
        else {
            return 0;
        }
    }
}
