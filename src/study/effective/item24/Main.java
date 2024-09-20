package study.effective.item24;

public class Main {
    public static void main(String[] args) {
        // 비정적 멤버 클래스 사용 예
        OuterClass outer = new OuterClass();
        OuterClass.NonStaticInner nonStaticInner = outer.new NonStaticInner();
        nonStaticInner.print();

        // 정적 멤버 클래스 사용 예
        OuterClass.StaticInner staticInner = new OuterClass.StaticInner();
        staticInner.print();
    }
}

class OuterClass {
    private int outerField = 10;

    // 비정적 멤버 클래스
    class NonStaticInner {
        void print() {
            // 바깥 클래스의 private 멤버에 접근 가능
            System.out.println("NonStaticInner: " + outerField);
        }
    }

    // 정적 멤버 클래스
    static class StaticInner {
        void print() {
            // 바깥 클래스의 인스턴스 멤버에 접근 불가
            System.out.println("StaticInner");
        }
    }
}
