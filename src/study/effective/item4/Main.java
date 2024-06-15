package study.effective.item4;

public class Main {
    public static void main(String[] args) {
        // MathUtils의 정적 메서드 사용
        System.out.println("5 + 3 = " + MathUtils.add(5, 3));
        System.out.println("5 - 3 = " + MathUtils.subtract(5, 3));

        // 아래 줄의 주석을 제거하면 컴파일 에러가 발생합니다.
        // MathUtils mathUtils = new MathUtils();  // 'MathUtils()' has private access
    }
}

// 인스턴스화를 막은 유틸리티 클래스
class MathUtils {
    // private 생성자
    private MathUtils() {
        throw new AssertionError("유틸리티 클래스는 인스턴스화할 수 없습니다.");
    }

    // 정적 메서드들
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }
}
