package study.effective.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 예제 리스트 생성
        List<String> words = Arrays.asList("short", "very long", "longer");

        // 익명 클래스를 사용한 정렬 (낡은 방식)
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        System.out.println("익명 클래스 사용 결과: " + words);

        // 리스트 초기화
        words = Arrays.asList("short", "very long", "longer");

        // 람다 표현식을 사용한 정렬 (새로운 방식)
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("람다 표현식 사용 결과: " + words);

        // 메서드 참조를 사용한 더 간단한 방식
        words = Arrays.asList("short", "very long", "longer");
        Collections.sort(words, Comparator.comparingInt(String::length));
        System.out.println("메서드 참조 사용 결과: " + words);
    }
}
