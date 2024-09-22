package study.effective.item26;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 로 타입 사용 (권장하지 않음)
        List rawList = new ArrayList();
        rawList.add("문자열");
        rawList.add(42);  // 컴파일 시 경고, 런타임 시 문제 발생 가능

        // 제네릭 타입 올바르게 사용
        List<String> stringList = new ArrayList<>();
        stringList.add("안전한 문자열");
        // stringList.add(42);  // 컴파일 오류

        // 비한정적 와일드카드 타입 사용
        printList(stringList);

        // List<Object>와 로 타입의 차이
        List<Object> objectList = new ArrayList<>();
        objectList.add("문자열");
        objectList.add(42);  // 컴파일 오류 없음, 타입 안전

        System.out.println("Raw type list: " + rawList);
        System.out.println("Generic type list: " + stringList);
        System.out.println("Object list: " + objectList);
    }

    // 비한정적 와일드카드 타입을 사용한 메서드
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
