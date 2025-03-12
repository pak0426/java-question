package study.effective.item58;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item58 {

    public static void main(String[] args) {
        // 1. 컬렉션 순회 비교
        demonstrateCollectionIteration();

        // 2. 배열 순회 비교
        demonstrateArrayIteration();

        // 3. 중첩 컬렉션 순회 비교
        demonstrateNestedIteration();

        // 4. for-each를 사용할 수 없는 상황
        demonstrateForEachLimitations();
    }

    private static void demonstrateCollectionIteration() {
        List<String> fruits = Arrays.asList("사과", "바나나", "오렌지");

        // 1. 전통적인 for 문 (인덱스 사용)
        System.out.println("전통적인 for 문:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        // 2. 반복자(Iterator) 사용
        System.out.println("반복자 사용:");
        for (var iterator = fruits.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        // 3. for-each 문 사용 (가장 간결하고 오류 가능성 낮음)
        System.out.println("for-each 문:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

    private static void demonstrateArrayIteration() {
        int[] numbers = {1, 2, 3, 4, 5};

        // 1. 전통적인 for 문
        System.out.println("배열 전통적 for 문:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // 2. for-each 문 (더 간결하고 안전함)
        System.out.println("배열 for-each 문:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void demonstrateNestedIteration() {
        List<String> suits = Arrays.asList("스페이드", "하트", "다이아몬드", "클로버");
        List<String> ranks = Arrays.asList("에이스", "킹", "퀸", "잭");

        // 1. 전통적인 중첩 for 문 (인덱스 사용)
        System.out.println("중첩 for 문 (인덱스):");
        for (int i = 0; i < suits.size(); i++) {
            for (int j = 0; j < ranks.size(); j++) {
                System.out.println(suits.get(i) + " " + ranks.get(j));
            }
        }

        // 2. 중첩 for-each 문 (더 간결하고 오류 가능성 낮음)
        System.out.println("중첩 for-each 문:");
        for (String suit : suits) {
            for (String rank : ranks) {
                System.out.println(suit + " " + rank);
            }
        }
    }

    private static void demonstrateForEachLimitations() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("for-each를 사용할 수 없는 상황들:");

        // 1. 파괴적인 필터링 (요소 제거)
        System.out.println("파괴적인 필터링 (전통적 for 문 사용):");
        for (var i = numbers.iterator(); i.hasNext();) {
            if (i.next() % 2 == 0) {
                i.remove(); // 짝수 제거
            }
        }
        System.out.println("짝수 제거 후: " + numbers);

        // 2. 변형 - 값 대체
        int[] values = {1, 2, 3};
        System.out.println("변형 (인덱스 필요):");
        for (int i = 0; i < values.length; i++) {
            values[i] *= 2; // 각 값을 2배로
        }
        System.out.println("값 변형 후: " + Arrays.toString(values));

        // 3. 병렬 순회
        String[] names = {"Alice", "Bob", "Charlie"};
        int[] scores = {90, 85, 95};

        System.out.println("병렬 순회 (인덱스로 두 배열 동시에 접근):");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + scores[i]);
        }
    }
}
