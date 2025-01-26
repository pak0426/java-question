package study.effective;

import java.util.*;
import java.util.stream.Collectors;

public class item46 {
    public static void main(String[] args) {
        // 샘플 데이터: 단어와 빈도수
        List<String> words = Arrays.asList(
                "hello", "world", "stream", "hello",
                "java", "stream", "effective", "java"
        );

        // 나쁜 예: 스트림과 외부 상태를 수정하는 로직을 혼합
        Map<String, Long> freq = new HashMap<>();
        words.stream().forEach(word ->
                freq.merge(word, 1L, Long::sum));
        System.out.println("Bad example result: " + freq);

        // 좋은 예: 수집기(collector)를 사용한 방식
        Map<String, Long> freqCorrect = words.stream()
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ));
        System.out.println("Good example result: " + freqCorrect);

        // 단어 빈도를 기준으로 상위 3개 단어 추출
        List<String> topThree = freqCorrect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Top three words: " + topThree);

        // 빈도수별로 단어들을 그룹화
        Map<Long, List<String>> wordsByFreq = words.stream()
                .collect(Collectors.groupingBy(
                        word -> freqCorrect.get(word),
                        Collectors.mapping(word -> word,
                                Collectors.toList())
                ));
        System.out.println("Words grouped by frequency: " + wordsByFreq);
    }
}
