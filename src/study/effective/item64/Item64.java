package study.effective.item64;

import java.util.*;

public class Item64 {
    public static void main(String[] args) {
        // 나쁜 예 - 구체 클래스로 참조
        LinkedHashSet<String> badPractice = new LinkedHashSet<>();

        // 좋은 예 - 인터페이스로 참조
        Set<String> goodPractice = new LinkedHashSet<>();

        // 구체 클래스에 기능이 필요한 특별한 경우만 사용
        LinkedHashSet<String> specialCase = new LinkedHashSet<>();
        int initialSize = specialCase.size(); // LinkedHashSet 특화 기능 필요시

        // 인터페이스 기반 코드의 유연성 예시
        Set<String> userSet = new HashSet<>();     // 초기 구현체
        userSet.add("user1");
        userSet.add("user2");
        System.out.println("HashSet 구현체: " + userSet);

        // 구현체 변경이 쉬움 - 코드 변경 불필요
        userSet = new LinkedHashSet<>(userSet);    // 순서 보존이 필요해져서 변경
        userSet.add("user3");
        System.out.println("LinkedHashSet으로 변경: " + userSet);

        // 팩토리 메서드 활용 예시
        List<String> names = createOptimizedList();
        names.add("홍길동");
        names.add("김철수");
        System.out.println("팩토리 메서드로 생성된 리스트: " + names);
    }

    // 인터페이스 반환 타입 사용 - 구현 세부사항 감춤
    private static List<String> createOptimizedList() {
        // 구현체는 내부 구현 세부사항으로 필요에 따라 변경 가능
        return new ArrayList<>();
    }
}
