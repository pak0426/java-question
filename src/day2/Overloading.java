package day2;

public class Overloading {
    public static void main(String args[]) {
        print();
        print("Hello!");
        print(10, 20);
    }

    public static void print() {
        System.out.println("print!");
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void print(int a, int b) {
        System.out.println(a);
        System.out.println(b);
    }
}
