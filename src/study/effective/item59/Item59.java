package study.effective.item59;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Item59 {

    public static void main(String[] args) {
        // 1. 난수 생성 예시
        demonstrateRandomExample();

        // 2. 문자열 처리 예시
        demonstrateStringProcessing();

        // 3. 날짜 처리 예시
        demonstrateDateProcessing();

        // 4. 컬렉션 처리 예시
        demonstrateCollectionProcessing();
    }

    private static void demonstrateRandomExample() {
        // 나쁜 예: 직접 구현한 난수 생성
        int badRandom = (int) (System.currentTimeMillis() % 100); // 품질이 좋지 않음

        // 좋은 예: 라이브러리 사용
        Random random = new Random();
        int goodRandom = random.nextInt(100);

        System.out.println("난수 예시: " + goodRandom);

        // 더 좋은 예: ThreadLocalRandom 사용 (Java 7+)
        int betterRandom = java.util.concurrent.ThreadLocalRandom.current().nextInt(100);
        System.out.println("스레드 안전한 난수: " + betterRandom);
    }

    private static void demonstrateStringProcessing() {
        String email = "user@example.com";

        // 나쁜 예: 직접 이메일 검증 (불완전함)
        boolean isValidBad = email.contains("@") && email.contains(".");

        // 좋은 예: 정규식 라이브러리 사용
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        boolean isValidGood = emailPattern.matcher(email).matches();

        System.out.println("이메일 유효성: " + isValidGood);
    }

    private static void demonstrateDateProcessing() {
        // 나쁜 예: 구식 Date 사용
        java.util.Date oldDate = new java.util.Date(); // 불변성 없음, 스레드 안전하지 않음

        // 좋은 예: Java 8 날짜/시간 API 사용
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(30);

        // 날짜 포맷팅
        String formattedDate = future.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("30일 후: " + formattedDate);
    }

    private static void demonstrateCollectionProcessing() {
        List<String> names = Arrays.asList("홍길동", "김철수", "이영희", "박민수");

        // 나쁜 예: 직접 구현한 셔플
        shuffleBad(names); // 자체 구현 - 편향될 가능성 있음

        // 좋은 예: 라이브러리 사용
        Collections.shuffle(names); // 더 균등하고 테스트된 알고리즘
        System.out.println("셔플된 이름: " + names);

        // 정렬 예시
        Collections.sort(names);
        System.out.println("정렬된 이름: " + names);
    }

    // 나쁜 셔플 구현 예시 (실제로는 이런 코드를 작성하지 말고 라이브러리 사용)
    private static void shuffleBad(List<String> list) {
        Random random = new Random();
        for (int i = 0; i < list.size(); i++) {
            int j = random.nextInt(list.size());
            Collections.swap(list, i, j);
        }
    }
}
