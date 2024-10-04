package study.effective.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        // 제네릭과 가변인수를 함께 사용하는 안전하지 않은 메서드
        String[] strings = pickTwo("Good", "Fast", "Cheap");
        System.out.println(strings[0] + " " + strings[1]);

        // 제네릭 가변인수를 안전하게 사용하는 메서드
        List<String> attributes = pickTwoSafely("Good", "Fast", "Cheap");
        System.out.println(attributes);

        // @SafeVarargs 애노테이션을 사용한 메서드
        List<Integer> integers = flattenSafely(
                List.of(1, 2),
                List.of(3, 4, 5),
                List.of(6, 7)
        );
        System.out.println(integers);
    }

    // 안전하지 않은 메서드 (잠재적인 힙 오염 발생)
    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // 도달할 수 없음
    }

    // 컴파일러 경고를 유발하는 메서드
    static <T> T[] toArray(T... args) {
        return args;
    }

    // 제네릭 가변인수를 안전하게 사용하는 메서드
    @SafeVarargs
    static <T> List<T> pickTwoSafely(T... elements) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(elements[0], elements[1]);
            case 1: return List.of(elements[0], elements[2]);
            case 2: return List.of(elements[1], elements[2]);
        }
        throw new AssertionError();
    }

    // @SafeVarargs 애노테이션을 사용한 안전한 메서드
    @SafeVarargs
    static <T> List<T> flattenSafely(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
}
