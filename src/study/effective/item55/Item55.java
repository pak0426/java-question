package study.effective.item55;

import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Item55 {

    public static void main(String[] args) {
        // 1. 옵셔널 기본 사용법
        Optional<String> maybeValue = findValueById(10);

        // 잘못된 사용법 - Optional을 null 체크처럼 사용
        if (maybeValue != null && maybeValue.isPresent()) { // != null 체크는 불필요함
            System.out.println("값 존재: " + maybeValue.get());
        }

        // 올바른 사용법
        maybeValue.ifPresent(value -> System.out.println("값 존재: " + value));

        // 2. orElse vs orElseGet 차이점 (중요)
        String result1 = maybeValue.orElse(getDefaultValue()); // getDefaultValue()는 항상 실행됨
        String result2 = maybeValue.orElseGet(() -> getDefaultValue()); // 값이 없을 때만 실행됨

        // 3. 예외 던지기
        try {
            String value = maybeValue.orElseThrow(() -> new NoSuchElementException("값을 찾을 수 없습니다"));
            System.out.println("값: " + value);
        } catch (NoSuchElementException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 4. 옵셔널 스트림 처리
        List<User> users = List.of(
                new User(1, "김철수"),
                new User(2, null),
                new User(3, "박영희")
        );

        // null이 아닌 이름만 필터링
        List<String> validNames = users.stream()
                .map(User::getOptionalName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        System.out.println("유효한 이름들: " + validNames);

        // Java 9 이상에서는 더 간결하게 처리 가능
        List<String> validNamesJava9 = users.stream()
                .map(User::getOptionalName)
                .flatMap(Optional::stream) // Java 9에서 추가된 stream() 메서드
                .toList();
    }

    // 옵셔널을 반환하는 메서드 예시
    private static Optional<String> findValueById(int id) {
        // DB 조회 등의 로직 (여기서는 간단한 예시)
        return id > 0 && id < 100 ? Optional.of("데이터: " + id) : Optional.empty();
    }

    private static String getDefaultValue() {
        System.out.println("기본값 생성 메서드 호출됨");
        return "기본값";
    }

    // 내부 클래스
    static class User {
        private final int id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // 옵셔널을 반환하는 메서드 (멤버 변수 접근용)
        public Optional<String> getOptionalName() {
            return Optional.ofNullable(name);
        }
    }
}
