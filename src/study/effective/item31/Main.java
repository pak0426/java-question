package study.effective.item31;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 생산자 예제
        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("Numbers: " + numbers);

        // 소비자 예제
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        printNumbers(integers);

        // PECS 원칙 예제
        List<Integer> src = new ArrayList<>();
        src.add(1);
        src.add(2);
        src.add(3);
        List<Number> dest = new ArrayList<>();
        copy(src, dest);
        System.out.println("Copied numbers: " + dest);
    }

    // 생산자(Producer) 매개변수에 와일드카드 적용
    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    // 소비자(Consumer) 매개변수에 와일드카드 적용
    public static void printNumbers(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    // PECS (Producer-Extends, Consumer-Super) 원칙 적용
    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);
        }
    }
}
