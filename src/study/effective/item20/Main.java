package study.effective.item20;

// 인터페이스 정의
interface Singable {
    void sing();

    // 디폴트 메서드
    default void introduce() {
        System.out.println("I can sing!");
    }
}

// 다른 인터페이스 정의
interface Danceable {
    void dance();
}

// 두 인터페이스를 구현하는 클래스
class Performer implements Singable, Danceable {
    @Override
    public void sing() {
        System.out.println("Lalala~");
    }

    @Override
    public void dance() {
        System.out.println("Dancing to the rhythm!");
    }
}

public class Main {
    public static void main(String[] args) {
        Performer performer = new Performer();
        performer.introduce(); // 디폴트 메서드 호출
        performer.sing();
        performer.dance();

        // 인터페이스를 통한 다형성
        Singable singer = new Performer();
        singer.sing();

        Danceable dancer = new Performer();
        dancer.dance();
    }
}
