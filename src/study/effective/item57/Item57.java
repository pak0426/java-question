package study.effective.item57;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Item57 {

    public static void main(String[] args) {
        // 1. 지역변수 범위 최소화 예시
        demonstrateMinimizedScope();

        // 2. for-each 루프 활용 예시
        demonstrateForEachLoop();

        // 3. while 루프 대신 for 루프 사용 예시
        demonstrateForVsWhileLoop();
    }

    private static void demonstrateMinimizedScope() {
        // 나쁜 예: 변수 범위가 넓음
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        // 작업 코드...
        System.out.println("리스트 크기: " + numbers.size());

        // 다른 작업...
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        // numbers 변수가 여전히 범위 내에 있음

        // 좋은 예: 변수 범위가 좁음
        {
            List<Integer> items = new ArrayList<>();
            items.add(3);
            items.add(4);
            System.out.println("아이템 합계: " + items.stream().mapToInt(Integer::intValue).sum());
        }
        // items 변수는 이 위치에서 범위를 벗어남
    }

    private static void demonstrateForEachLoop() {
        List<String> names = List.of("김철수", "이영희", "박민수");

        // 나쁜 예: 인덱스 기반 루프
        for (int i = 0; i < names.size(); i++) {
            System.out.println("이름 " + (i + 1) + ": " + names.get(i));
        }

        // 좋은 예: for-each 루프 (더 간결하고 에러 가능성이 낮음)
        for (String name : names) {
            System.out.println("안녕하세요, " + name);
        }
    }

    private static void demonstrateForVsWhileLoop() {
        Random random = new Random();

        // 나쁜 예: while 루프 사용 (변수 범위가 메서드 전체)
        Iterator<Integer> iterator = createSampleData().iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            // 작업 수행
            System.out.println("값: " + value);
        }

        // 좋은 예: for 루프 사용 (변수 범위가 루프 내부로 제한됨)
        for (Iterator<Integer> it = createSampleData().iterator(); it.hasNext(); ) {
            Integer value = it.next();
            // 작업 수행
            System.out.println("값(for): " + value);
        }
    }

    private static List<Integer> createSampleData() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(i + 1);
        }
        return data;
    }
}
