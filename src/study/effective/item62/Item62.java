package study.effective.item62;

import java.awt.Point;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Item62 {

    public static void main(String[] args) {
        // 1. 문자열을 열거 타입으로 대체
        demonstrateEnumInsteadOfString();

        // 2. 문자열을 클래스로 대체
        demonstrateClassInsteadOfString();

        // 3. 문자열을 기본 타입으로 대체
        demonstratePrimitiveInsteadOfString();

        // 4. 문자열 키를 열거 타입으로 대체
        demonstrateEnumAsKey();
    }

    private static void demonstrateEnumInsteadOfString() {
        System.out.println("1. 문자열 대신 열거 타입 사용:");

        // 나쁜 예: 문자열 상수 사용
        String status = "PENDING";

        // 문자열은 오타 가능성이 있고 타입 안전하지 않음
        if (status.equals("PENDNG")) { // 오타!
            System.out.println("대기 중");
        }

        // 좋은 예: 열거 타입 사용
        OrderStatus orderStatus = OrderStatus.PENDING;

        // 컴파일러가 타입 체크, IDE의 자동 완성 지원
        if (orderStatus == OrderStatus.PENDING) {
            System.out.println("열거 타입: 대기 중");
        }
    }

    private static void demonstrateClassInsteadOfString() {
        System.out.println("\n2. 문자열 대신 클래스 사용:");

        // 나쁜 예: 좌표를 문자열로 표현
        String point = "10,20";

        // 문자열 파싱 작업 필요
        String[] parts = point.split(",");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        System.out.println("문자열에서 파싱한 좌표: (" + x + ", " + y + ")");

        // 좋은 예: 전용 클래스 사용
        Point pointObj = new Point(10, 20);
        System.out.println("Point 객체 좌표: (" + pointObj.x + ", " + pointObj.y + ")");
    }

    private static void demonstratePrimitiveInsteadOfString() {
        System.out.println("\n3. 문자열 대신 기본 타입 사용:");

        // 나쁜 예: 숫자를 문자열로 처리
        String number = "42";
        String result = number + number; // "4242"가 됨
        System.out.println("문자열 연결 결과: " + result);

        // 좋은 예: 적절한 숫자 타입 사용
        int num = 42;
        int sum = num + num; // 84가 됨
        System.out.println("숫자 덧셈 결과: " + sum);

        // 큰 정수는 BigInteger 사용
        BigInteger bigNum = new BigInteger("9876543210");
        BigInteger squared = bigNum.multiply(bigNum);
        System.out.println("BigInteger 제곱 결과: " + squared);
    }

    private static void demonstrateEnumAsKey() {
        System.out.println("\n4. 문자열 키 대신 열거 타입 키 사용:");

        // 나쁜 예: 문자열을 맵 키로 사용
        Map<String, Integer> stringStatusMap = new HashMap<>();
        stringStatusMap.put("PENDING", 10);
        stringStatusMap.put("PROCESSING", 5);

        // 오타 가능성 있음
        int count = stringStatusMap.getOrDefault("PENDNG", 0); // 오타!
        System.out.println("문자열 키 오타 시 결과: " + count); // 0 반환 (의도치 않은 결과)

        // 좋은 예: 열거 타입을 맵 키로 사용
        Map<OrderStatus, Integer> enumStatusMap = new HashMap<>();
        enumStatusMap.put(OrderStatus.PENDING, 10);
        enumStatusMap.put(OrderStatus.PROCESSING, 5);

        // 컴파일러가 타입 검사 수행, IDE 자동 완성 지원
        int enumCount = enumStatusMap.getOrDefault(OrderStatus.PENDING, 0);
        System.out.println("열거 타입 키 사용 시 결과: " + enumCount); // 10 반환
    }

    // 열거 타입 예시
    enum OrderStatus {
        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELED
    }
}
