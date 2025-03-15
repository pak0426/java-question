package study.effective.item61;

public class Item61 {

    public static void main(String[] args) {
        // 1. 식별성 비교 문제
        demonstrateIdentityIssue();

        // 2. null 참조 문제
        demonstrateNullReference();

        // 3. 성능 이슈
        demonstratePerformance();

        // 4. 올바른 사용 예시
        demonstrateCorrectUsage();
    }

    private static void demonstrateIdentityIssue() {
        System.out.println("1. 식별성 비교 문제:");

        // 동일한 값이지만 다른 객체
        Integer a = new Integer(42);
        Integer b = new Integer(42);

        System.out.println("a == b: " + (a == b));           // false (다른 객체)
        System.out.println("a.equals(b): " + a.equals(b));   // true (값은 같음)

        // 오토박싱과 캐싱 동작
        Integer c = 127;
        Integer d = 127;
        System.out.println("c == d (127): " + (c == d));     // true (캐싱됨, -128~127)

        Integer e = 128;
        Integer f = 128;
        System.out.println("e == f (128): " + (e == f));     // false (캐싱 범위 초과)
    }

    private static void demonstrateNullReference() {
        System.out.println("\n2. null 참조 문제:");

        Integer intObj = null;
        try {
            // 자동 언박싱 시 NullPointerException 발생
            int result = intObj + 10;
            System.out.println(result);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생: " + e.getMessage());
        }
    }

    private static void demonstratePerformance() {
        System.out.println("\n3. 성능 이슈:");

        // 기본 타입 연산
        long start = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < 10_000_000; i++) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("기본 타입 연산 시간: " + (end - start) / 1_000_000.0 + "ms");

        // 박싱 타입 연산 (오토박싱/언박싱 발생)
        start = System.nanoTime();
        Integer boxedSum = 0;  // 박싱
        for (int i = 0; i < 10_000_000; i++) {
            boxedSum += i;     // 언박싱, 계산, 다시 박싱 발생
        }
        end = System.nanoTime();
        System.out.println("박싱 타입 연산 시간: " + (end - start) / 1_000_000.0 + "ms");
    }

    private static void demonstrateCorrectUsage() {
        System.out.println("\n4. 올바른 사용 예시:");

        // 컬렉션에서는 박싱된 기본 타입 사용 (컬렉션은 객체만 저장 가능)
        java.util.List<Integer> numbers = java.util.Arrays.asList(1, 2, 3, 4, 5);

        // 스트림에서 기본 타입 특화 스트림 사용
        int total = numbers.stream()
                .mapToInt(Integer::intValue)  // 박싱 → 기본 타입 (IntStream)
                .sum();                        // 기본 타입으로 연산
        System.out.println("합계: " + total);

        // 박싱된 기본 타입에 == 연산자 사용 피하기
        Integer x = 1000;
        Integer y = 1000;
        System.out.println("x == y: " + (x == y));           // false, 같은 값이지만 다른 객체
        System.out.println("x.equals(y): " + x.equals(y));   // true, 값 비교는 equals 사용
    }
}
