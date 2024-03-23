package study.effective.item3;

public class Main {
    public static void main(String[] args) {
        // 1. public static final 필드 방식
        Singleton1 singleton1 = Singleton1.INSTANCE;
        singleton1.leaveTheBuilding();

        // 2. 정적 팩터리 메서드 방식
        Singleton2 singleton2 = Singleton2.getInstance();
        singleton2.leaveTheBuilding();

        // 3. 열거 타입 방식
        Singleton3 singleton3 = Singleton3.INSTANCE;
        singleton3.leaveTheBuilding();
    }
}

// 1. public static final 필드 방식
class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1() {}
    public void leaveTheBuilding() {
        System.out.println("Singleton1 is leaving the building.");
    }
}

// 2. 정적 팩터리 메서드 방식
class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();
    private Singleton2() {}
    public static Singleton2 getInstance() { return INSTANCE; }
    public void leaveTheBuilding() {
        System.out.println("Singleton2 is leaving the building.");
    }
}

// 3. 열거 타입 방식
enum Singleton3 {
    INSTANCE;
    public void leaveTheBuilding() {
        System.out.println("Singleton3 is leaving the building.");
    }
}
