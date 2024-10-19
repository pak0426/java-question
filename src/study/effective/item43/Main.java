package study.effective.item43;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.BiPredicate;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 예제 1: 정적 메서드 참조
        Function<String, Integer> stringToInteger = Integer::parseInt;
        System.out.println("String to Integer: " + stringToInteger.apply("42"));

        // 예제 2: 한정적 인스턴스 메서드 참조
        String str = "hello";
        Supplier<String> upperCase = str::toUpperCase;
        System.out.println("Uppercase: " + upperCase.get());

        // 예제 3: 비한정적 인스턴스 메서드 참조
        BiPredicate<String, String> equalsMethod = String::equals;
        System.out.println("Equals method: " + equalsMethod.test("hello", "hello"));

        // 예제 4: 클래스 생성자 참조
        Supplier<Map<String, Integer>> mapSupplier = HashMap::new;
        Map<String, Integer> map = mapSupplier.get();
        map.put("key", 0);
        System.out.println("Map: " + map);

        // 예제 5: 배열 생성자 참조
        Function<Integer, String[]> arrayCreator = String[]::new;
        String[] array = arrayCreator.apply(3);
        array[0] = "First";
        array[1] = "Second";
        array[2] = "Third";
        System.out.println("Array: " + String.join(", ", array));

        // 람다와 메서드 참조 비교
        Map<String, Integer> frequencies = new HashMap<>();
        frequencies.put("Word", 1);

        // 람다 사용
        frequencies.merge("Word", 1, (count, incr) -> count + incr);

        // 메서드 참조 사용 (더 간결함)
        frequencies.merge("Word", 1, Integer::sum);

        System.out.println("Final frequency: " + frequencies.get("Word"));
    }
}
