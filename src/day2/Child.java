package day2;

public class Child extends Parent{
    @Override
    public void print() {
        System.out.println("Child!");
    }

    @Override
    public void plus(int a, int b) {
        System.out.println(b + a);
    }

    @Override
    public void multiple(int a, int b, int c) {
        System.out.println(c * b * a);
    }

    @Override
    public void division(int a, int b, String str) {
        System.out.println((b / a) + " " + str);
    }
}
