package study.enum_sample.case1;

import study.enum_sample.case1.FruitEnum;

public class Main {
    public static void main(String args[]) {
        FruitEnum fruitEnumY = FruitEnum.Y;
        FruitEnum fruitEnumN = FruitEnum.N;

        System.out.println("fruitEnumY = " + fruitEnumY.getValue() + " " + fruitEnumY.isFlag());
        System.out.println("fruitEnumN = " + fruitEnumN.getValue() + " " + fruitEnumN.isFlag());
    }
}
