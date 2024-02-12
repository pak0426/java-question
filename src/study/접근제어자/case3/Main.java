package study.접근제어자.case3;

import study.접근제어자.case1.Snack;

public class Main {
    public static void main(String args[]) {
        Snack snack = new Snack("nacho", 2000);
        // getName() protected 메서드 호출 불가

        int price = snack.price;
        //snack.company -> private 호출 불가
        System.out.println("price = " + price);
    }
}
