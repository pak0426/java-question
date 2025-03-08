package study.effective.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 이펙티브 자바 아이템 54: "null이 아닌, 빈 컬렉션이나 배열을 반환하라"
 */
public class Item54 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 54 예제 =========");
        System.out.println("null이 아닌, 빈 컬렉션이나 배열을 반환하라\n");

        CheeseShop shop = new CheeseShop();

        // 1. null을 반환하는 나쁜 예시
        System.out.println("1. null을 반환하는 나쁜 예시:");
        List<Cheese> badCheeses = shop.getCheesesBad(); // null 반환 가능

        // 클라이언트 코드에서 null 체크가 필요함
        if (badCheeses != null) {
            System.out.println("  치즈 종류: " + badCheeses);
        } else {
            System.out.println("  치즈가 없습니다.");
        }

        // 2. 빈 컬렉션을 반환하는 좋은 예시
        System.out.println("\n2. 빈 컬렉션을 반환하는 좋은 예시:");
        List<Cheese> goodCheeses = shop.getCheesesGood();

        // null 체크가 필요 없음
        System.out.println("  치즈 종류: " + goodCheeses);
        System.out.println("  치즈 개수: " + goodCheeses.size());

        // 3. 최적화: 빈 불변 컬렉션 반환
        System.out.println("\n3. 최적화: 빈 불변 컬렉션 반환:");
        List<Cheese> optimizedCheeses = shop.getCheesesOptimized();
        System.out.println("  치즈 종류: " + optimizedCheeses);
        System.out.println("  빈 컬렉션은 불변 객체를 공유하여 메모리 최적화");

        // 4. 배열의 경우
        System.out.println("\n4. 배열 반환의 경우:");

        // 4.1 null 반환 (나쁜 예)
        Cheese[] badArray = shop.getCheeseArrayBad();
        if (badArray != null) {
            System.out.println("  배열 길이: " + badArray.length);
        } else {
            System.out.println("  치즈 배열이 없습니다.");
        }

        // 4.2 길이 0 배열 반환 (좋은 예)
        Cheese[] goodArray = shop.getCheeseArrayGood();
        System.out.println("\n  빈 배열 반환 (매번 새로 할당):");
        System.out.println("  배열 길이: " + goodArray.length);

        // 4.3 미리 할당된 빈 배열 반환 (최적화)
        Cheese[] optimizedArray = shop.getCheeseArrayOptimized();
        System.out.println("\n  미리 할당된 빈 배열 반환 (최적화):");
        System.out.println("  배열 길이: " + optimizedArray.length);
    }

    // 치즈 클래스
    static class Cheese {
        private final String name;

        Cheese(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // 치즈 가게 클래스
    static class CheeseShop {
        // 실제로는 더 많은 치즈가 있을 수 있음
        private final List<Cheese> cheeses = new ArrayList<>();

        // 미리 할당해 놓은 빈 배열 (성능 최적화)
        private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

        // 1. null을 반환하는 나쁜 방식
        public List<Cheese> getCheesesBad() {
            if (cheeses.isEmpty()) {
                return null; // 컬렉션이 비었을 때 null 반환 (나쁜 방식)
            }
            return new ArrayList<>(cheeses);
        }

        // 2. 빈 컬렉션을 반환하는 좋은 방식
        public List<Cheese> getCheesesGood() {
            if (cheeses.isEmpty()) {
                return new ArrayList<>(); // 빈 컬렉션 반환
            }
            return new ArrayList<>(cheeses);
        }

        // 3. 최적화: 빈 불변 컬렉션 반환
        public List<Cheese> getCheesesOptimized() {
            if (cheeses.isEmpty()) {
                return Collections.emptyList(); // 미리 정의된 빈 불변 리스트 반환
            }
            return new ArrayList<>(cheeses);
        }

        // 4.1 null 배열 반환 (나쁜 예)
        public Cheese[] getCheeseArrayBad() {
            if (cheeses.isEmpty()) {
                return null; // null 반환 (나쁜 방식)
            }
            return cheeses.toArray(new Cheese[0]);
        }

        // 4.2 길이 0 배열 반환 (좋은 예)
        public Cheese[] getCheeseArrayGood() {
            if (cheeses.isEmpty()) {
                return new Cheese[0]; // 길이 0 배열 생성 (매번 새로 할당)
            }
            return cheeses.toArray(new Cheese[0]);
        }

        // 4.3 미리 할당된 빈 배열 반환 (최적화)
        public Cheese[] getCheeseArrayOptimized() {
            if (cheeses.isEmpty()) {
                return EMPTY_CHEESE_ARRAY; // 미리 할당된 빈 배열 (공유)
            }
            return cheeses.toArray(new Cheese[0]);
        }
    }
}
