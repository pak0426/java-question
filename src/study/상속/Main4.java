package study.상속;

public class Main4 {
    private static class A {
        private A() {
            System.out.println("A");
        }
    }

    private static class B extends A {
        private B() {
            System.out.println("B");
        }
    }

    private static class C extends A {
        private C() {
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
        A a = new C();
    }
}
