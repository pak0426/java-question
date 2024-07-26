package study.상속;

public class Main2 {
    private static abstract class Animal {
        abstract void value();
        void key() {
            System.out.print("animal");
        }

        void cry() {
            System.out.print("엉엉");
        }
    }

    private static class Dog extends Animal {
        @Override
        void value() {
            System.out.print("dog");
        }

        void cry() {
            System.out.print("멍멍");
        }
    }

    public static void main(String[] args) {
        Animal d = new Dog();
        d.key();
        d.value();
        d.cry();
    }
}
