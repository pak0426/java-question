package study.effective.item49;

import java.util.Objects;

/**
 * 이펙티브 자바 아이템 49: "매개변수가 유효한지 검사하라"
 */
public class Item49 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 49 예제 =========");
        System.out.println("매개변수가 유효한지 검사하라\n");

        try {
            // 1. 일반적인 매개변수 검사
            System.out.println("1. 기본 매개변수 검사:");
            String result = substring("Hello, World", 0, 5);
            System.out.println("  결과: " + result);

            // 오류 발생 케이스
            System.out.println("\n  잘못된 입력으로 시도:");
            substring("Hello", -1, 3); // beginIndex가 음수
        } catch (IllegalArgumentException e) {
            System.out.println("  예상된 예외 발생: " + e.getMessage());
        }

        try {
            // 2. Objects.requireNonNull 사용
            System.out.println("\n2. Objects.requireNonNull 사용:");
            String name = "Claude";
            Objects.requireNonNull(name, "이름은 null이 될 수 없습니다");
            System.out.println("  유효한 이름: " + name);

            // null 입력으로 테스트
            System.out.println("\n  null 입력으로 시도:");
            processName(null);
        } catch (NullPointerException e) {
            System.out.println("  예상된 예외 발생: " + e.getMessage());
        }

        try {
            // 3. assert 문 사용 (비공개 도우미 메서드)
            System.out.println("\n3. 비공개 도우미 메서드에서 assert 사용:");
            int[] array = {1, 2, 3, 4, 5};
            System.out.println("  배열의 합: " + sum(array, 0, 5));

            // 잘못된 범위로 테스트
            System.out.println("\n  잘못된 범위로 시도:");
            // 참고: assert는 -ea 옵션을 켜야 활성화됨
            sum(array, 0, 10); // 범위 초과
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  예상된 예외 발생: " + e.getMessage());
        }
    }

    /**
     * 문자열의 부분 문자열을 반환하는 메서드 (매개변수 검사 포함)
     */
    public static String substring(String s, int beginIndex, int endIndex) {
        // 매개변수 유효성 검사
        if (beginIndex < 0) {
            throw new IllegalArgumentException("beginIndex는 음수가 될 수 없습니다: " + beginIndex);
        }
        if (endIndex > s.length()) {
            throw new IllegalArgumentException("endIndex가 문자열 길이를 초과합니다: " + endIndex);
        }
        if (beginIndex > endIndex) {
            throw new IllegalArgumentException("beginIndex가 endIndex보다 큽니다: "
                    + beginIndex + " > " + endIndex);
        }

        return s.substring(beginIndex, endIndex);
    }

    /**
     * Objects.requireNonNull을 사용한 null 검사 예제
     */
    public static void processName(String name) {
        // 한 줄로 null 검사 및 예외 메시지 지정
        String nonNullName = Objects.requireNonNull(name, "이름은 null이 될 수 없습니다");
        System.out.println("  처리된 이름: " + nonNullName);
    }

    /**
     * 비공개 도우미 메서드에서 assert를 사용한 예제
     */
    public static int sum(int[] array, int from, int to) {
        // 공개 API의 경우 명시적 검사가 필요하지만,
        // 비공개 도우미 메서드에서는 assert를 사용할 수 있음
        assert from >= 0 && from <= array.length : "시작 인덱스가 범위를 벗어납니다: " + from;
        assert to >= 0 && to <= array.length : "끝 인덱스가 범위를 벗어납니다: " + to;
        assert from <= to : "시작 인덱스가 끝 인덱스보다 큽니다: " + from + " > " + to;

        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += array[i];
        }
        return sum;
    }
}
