package study.effective.item52;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.math.BigInteger;
import java.util.*;

/**
 * 이펙티브 자바 아이템 52: "다중정의는 신중히 사용하라"
 */
public class Item52 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 52 예제 =========");
        System.out.println("다중정의는 신중히 사용하라\n");

        // 1. 다중정의(오버로딩)로 인한 혼란 예시
        System.out.println("1. 다중정의로 인한 혼란 예시:");

        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println("  컬렉션 타입: " + c.getClass().getSimpleName());
            // 컴파일 타임에는 for문 안의 c가 항상 Collection<?> 타입으로 보임
            // 따라서 항상 classify(Collection) 메서드가 호출됨
            System.out.println("  호출된 메서드: " + classify(c));
        }

        // 2. 재정의(오버라이딩)는 예상대로 동작
        System.out.println("\n2. 재정의(오버라이딩)는 예상대로 동작:");
        List<Wine> wineList = List.of(
                new Wine(), new SparklingWine(), new Champagne()
        );

        for (Wine wine : wineList) {
            System.out.println("  와인 타입: " + wine.getClass().getSimpleName());
            // 동적 디스패치: 실행 시점의 객체 타입에 따라 재정의된 메서드가 호출됨
            System.out.println("  와인 이름: " + wine.name());
        }

        // 3. 다중정의 대신 명확한 이름을 가진 메서드 사용
        System.out.println("\n3. 다중정의 대신 명확한 이름을 가진 메서드 사용:");
        ObjectSizer sizer = new ObjectSizer();

        Integer[] intArray = {1, 2, 3};
        List<Integer> intList = Arrays.asList(1, 2, 3);

        // 메서드 이름으로 의도가 명확함
        System.out.println("  배열 크기: " + sizer.sizeOfArray(intArray));
        System.out.println("  리스트 크기: " + sizer.sizeOfList(intList));

        // 4. 매개변수 수가 같은 다중정의는 피하기
        System.out.println("\n4. 매개변수 수가 같은 다중정의 피하기:");

        String hello = "Hello";
        char[] helloArray = {'H', 'e', 'l', 'l', 'o'};

        // 이런 다중정의는 혼란스러울 수 있음
        System.out.println("  문자열 출력: " + StringUtils.join(hello, 3));
        System.out.println("  문자 배열 출력: " + StringUtils.join(helloArray, 3));
    }

    // 다중정의된 메서드들 - 컴파일 타임 타입에 따라 결정됨
    static String classify(Set<?> s) {
        return "집합";
    }

    static String classify(List<?> lst) {
        return "리스트";
    }

    static String classify(Collection<?> c) {
        return "그 외 컬렉션";
    }

    // 재정의를 보여주는 클래스 계층
    static class Wine {
        String name() { return "포도주"; }
    }

    static class SparklingWine extends Wine {
        @Override
        String name() { return "발포성 포도주"; }
    }

    static class Champagne extends SparklingWine {
        @Override
        String name() { return "샴페인"; }
    }

    // 다중정의 대신 명확한 이름을 가진 메서드 사용 예시
    static class ObjectSizer {
        int sizeOfArray(Object[] array) {
            return array.length;
        }

        int sizeOfList(List<?> list) {
            return list.size();
        }
    }

    // 매개변수 수가 같은 다중정의 예시
    static class StringUtils {
        // 문자열을 다루는 메서드
        static String join(String s, int count) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                result.append(s);
            }
            return result.toString();
        }

        // 문자 배열을 다루는 메서드 (혼란을 일으킬 수 있음)
        static String join(char[] chars, int count) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                result.append(new String(chars));
            }
            return result.toString();
        }

        // 더 나은 설계: 이름을 다르게 해서 혼란 방지
        static String joinChars(char[] chars, int count) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < count; i++) {
                result.append(new String(chars));
            }
            return result.toString();
        }
    }
}