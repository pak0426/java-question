package study.effective.Item66;

public class Item66 {
    public static void main(String[] args) {
        // 네이티브 메서드를 사용하는 예시
        NativeExample nativeExample = new NativeExample();

        // 네이티브 메서드 호출 전 메모리 사용량 확인
        long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("네이티브 메서드 호출 전 메모리: " + beforeMemory + " bytes");

        // 1. 네이티브 메서드 호출 (실제로는 JNI 구현이 필요함)
        String result = nativeExample.performCriticalOperation("테스트 데이터");
        System.out.println("네이티브 메서드 결과: " + result);

        // 네이티브 메서드 호출 후 메모리 사용량 확인
        long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("네이티브 메서드 호출 후 메모리: " + afterMemory + " bytes");

        // 2. 순수 자바 대안 사용
        JavaAlternative javaAlt = new JavaAlternative();
        String javaResult = javaAlt.performOperation("테스트 데이터");
        System.out.println("순수 자바 대안 결과: " + javaResult);

        // 3. 성능 비교 예시
        PerformanceComparer comparer = new PerformanceComparer();
        comparer.comparePerformance();
    }
}

// 네이티브 메서드를 사용하는 클래스
class NativeExample {
    // 네이티브 라이브러리 로드 (실제 구현 시 필요)
    static {
        try {
            // System.loadLibrary("nativelib");
            System.out.println("네이티브 라이브러리 로드 시도 (예시용)");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("네이티브 라이브러리 로드 실패 (예상된 결과): " + e.getMessage());
        }
    }

    // 네이티브 메서드 선언 (실제 구현 필요)
    // 실제로는 C/C++ 구현이 필요하지만, 예시이므로 자바로 대체 구현
    public native String nativeOperation(String input);

    // 네이티브 메서드를 사용하는 자바 메서드
    public String performCriticalOperation(String input) {
        // 실제 네이티브 메서드 대신 자바 구현으로 시뮬레이션
        return "네이티브 메서드 호출 결과 (시뮬레이션): " + input.toUpperCase();
    }
}

// 순수 자바 대안 클래스
class JavaAlternative {
    // 네이티브 메서드 대신 사용할 수 있는 순수 자바 구현
    public String performOperation(String input) {
        // 순수 자바로 구현된 동일 기능
        return "순수 자바 구현 결과: " + input.toUpperCase();
    }
}

// 성능 비교 클래스
class PerformanceComparer {
    private static final int ITERATIONS = 1_000_000;

    public void comparePerformance() {
        NativeExample nativeExample = new NativeExample();
        JavaAlternative javaAlt = new JavaAlternative();

        // 순수 자바 구현 성능 측정
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            javaAlt.performOperation("test");
        }
        long javaTime = System.nanoTime() - startTime;

        // 네이티브 메서드 (시뮬레이션) 성능 측정
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            nativeExample.performCriticalOperation("test");
        }
        long nativeTime = System.nanoTime() - startTime;

        System.out.println("\n--- 성능 비교 결과 ---");
        System.out.println("순수 자바 실행 시간: " + javaTime / 1_000_000 + " ms");
        System.out.println("네이티브 메서드 실행 시간: " + nativeTime / 1_000_000 + " ms");
        System.out.println("성능 차이: " + String.format("%.2f", (double)nativeTime/javaTime) + "배");

        // 네이티브 메서드 사용 주의사항 설명
        System.out.println("\n--- 네이티브 메서드 사용 주의사항 ---");
        System.out.println("1. 안전하지 않음 - 메모리 훼손 가능성");
        System.out.println("2. 플랫폼 종속적 - 이식성 저하");
        System.out.println("3. 디버깅 어려움");
        System.out.println("4. 성능 향상 보장 없음 - JVM 최적화 우회");
        System.out.println("5. 가비지 컬렉터의 자원 회수 어려움");
    }
}
