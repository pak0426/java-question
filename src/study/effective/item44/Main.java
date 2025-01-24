package study.effective.item44;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // 1. 기본 함수형 인터페이스 사용
        Predicate<String> isLongWord = str -> str.length() > 5;
        Consumer<String> printer = System.out::println;
        Function<String, Integer> parser = Integer::parseInt;
        Supplier<List<String>> listSupplier = ArrayList::new;

        // 실행 예제
        System.out.println("Is long word: " + isLongWord.test("effective"));
        printer.accept("Hello functional!");
        System.out.println("Parsed number: " + parser.apply("123"));
        List<String> newList = listSupplier.get();
        System.out.println("New list created: " + newList);

        // 2. 기본타입 특화 인터페이스 사용
        IntPredicate isPositive = num -> num > 0;
        LongConsumer longPrinter = num -> System.out.println("Long: " + num);

        System.out.println("Is positive: " + isPositive.test(42));
        longPrinter.accept(123L);
    }
}
