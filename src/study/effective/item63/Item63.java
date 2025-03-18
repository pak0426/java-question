package study.effective.item63;

import java.util.ArrayList;
import java.util.List;

public class Item63 {

    public static void main(String[] args) {
        // 1. 문자열 연결 연산자(+) 성능 측정
        demonstrateStringConcatenation();

        // 2. StringBuilder 성능 측정
        demonstrateStringBuilder();

        // 3. 다양한 상황에서의 문자열 연결 전략
        demonstrateStringConcatenationStrategies();
    }

    private static void demonstrateStringConcatenation() {
        System.out.println("1. 문자열 연결 연산자(+) 성능 측정:");

        String result = "";
        long startTime = System.nanoTime();

        // 문자열 + 연산자 사용 (느림)
        for (int i = 0; i < 10_000; i++) {
            result += "item" + i;  // 매 반복마다 새로운 String 객체 생성
        }

        long endTime = System.nanoTime();
        System.out.println("문자열 + 연산자 소요 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");
        System.out.println("결과 문자열 길이: " + result.length());
    }

    private static void demonstrateStringBuilder() {
        System.out.println("\n2. StringBuilder 성능 측정:");

        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();

        // StringBuilder 사용 (빠름)
        for (int i = 0; i < 10_000; i++) {
            sb.append("item").append(i);  // 단일 StringBuilder 객체 사용
        }

        String result = sb.toString();
        long endTime = System.nanoTime();
        System.out.println("StringBuilder 소요 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");
        System.out.println("결과 문자열 길이: " + result.length());
    }

    private static void demonstrateStringConcatenationStrategies() {
        System.out.println("\n3. 다양한 상황에서의 문자열 연결 전략:");

        // 1) 적은 수의 문자열 연결 (컴파일러 최적화로 +도 괜찮음)
        String name = "홍" + "길" + "동";  // 컴파일 타임에 최적화됨
        System.out.println("컴파일 타임 최적화: " + name);

        // 2) 루프 내 문자열 연결 (StringBuilder 사용 필요)
        List<String> list = new ArrayList<>();
        list.add("사과");
        list.add("바나나");
        list.add("오렌지");

        // 좋지 않은 방법: 루프 내 + 연산자
        String badResult = "";
        for (String item : list) {
            badResult += item + ", ";  // 비효율적
        }

        // 좋은 방법: StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append(", ");  // 효율적
        }
        String goodResult = sb.toString();

        System.out.println("+ 연산자 결과: " + badResult);
        System.out.println("StringBuilder 결과: " + goodResult);

        // 3) StringBuffer vs StringBuilder (스레드 안전성)
        System.out.println("\n멀티스레드 환경:");
        System.out.println("- StringBuffer: 스레드 안전, 약간 느림");
        System.out.println("- StringBuilder: 스레드 안전하지 않음, 더 빠름");

        // 4) 문자열 연결 개수를 알고 있는 경우 초기 용량 지정
        StringBuilder sbWithCapacity = new StringBuilder(100);  // 초기 용량 지정
        System.out.println("초기 용량을 지정하면 확장 비용 절약: " + sbWithCapacity.capacity());
    }
}
