package study.effective.item45;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("stream", "lambda", "effective", "java", "programming");

        // 1. 스트림 체이닝 예제
        long longWords = words.stream()
                .filter(word -> word.length() > 6)
                .count();
        System.out.println("Long words count: " + longWords);

        // 2. 스트림 변환 예제
        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase words: " + upperWords);

        // 3. 스트림 리듀싱 예제
        String concatenated = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Concatenated: " + concatenated);

        // 4. 전통적인 반복문이 더 알맞은 예제
        for (String word : words) {
            if (word.contains("a")) {
                System.out.println("Found word with 'a': " + word);
                break;
            }
        }
    }
}
