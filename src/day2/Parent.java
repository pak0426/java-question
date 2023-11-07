package day2;

public class Parent {
    public void print() {
        System.out.println("Parent!");
    }

    public void plus(int a, int b) {
        System.out.println(a + b);
    }

    public void multiple(int a, int b, int c) {
        System.out.println(a * b * c);
    }

    public void division(int a, int b, String str) {
        System.out.println(str + " " + (a / b));
    }

}
