package study.effective.item51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 이펙티브 자바 아이템 51: "메서드 시그니처를 신중히 설계하라"
 */
public class Item51 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 51 예제 =========");
        System.out.println("메서드 시그니처를 신중히 설계하라\n");

        // 1. 메서드 이름을 신중히 짓기
        System.out.println("1. 메서드 이름을 명확하게:");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("홍길동", "010-1234-5678");
        phoneBook.addContact("김철수", "010-9876-5432");

        // 명확한 이름의 메서드 사용
        System.out.println("  연락처 검색: " + phoneBook.findByName("홍길동"));

        // 2. 편의 메서드 제공하기
        System.out.println("\n2. 편의 메서드 제공:");
        // 여러 파라미터를 받는 메서드 대신 편의 메서드 사용
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);

        // 편의 메서드 사용
        System.out.println("  정렬 전: " + numbers);
        Collections.sort(numbers); // 단일 인자 편의 메서드
        System.out.println("  정렬 후: " + numbers);

        // 3. 매개변수 목록 줄이기
        System.out.println("\n3. 매개변수 목록 줄이기:");

        // 3.1 도우미 클래스를 활용한 매개변수 그룹화
        Rectangle rectangle = new Rectangle(new Point(10, 20), new Dimension(100, 50));
        System.out.println("  사각형: " + rectangle);

        // 나쁜 예: 매개변수가 너무 많은 메서드
        System.out.println("\n  나쁜 예 (많은 매개변수):");
        badMethodWithManyParameters(1, 2, 3, 4, "많은", "매개변수");

        // 개선된 예: 매개변수를 그룹화한 메서드
        System.out.println("\n  개선된 예 (매개변수 그룹화):");
        Configuration config = new Configuration(1, 2, 3, 4);
        betterMethodWithGroupedParameters(config, "그룹화된", "매개변수");

        // 4. 매개변수 타입으로는 클래스보다 인터페이스가 더 좋다
        System.out.println("\n4. 매개변수 타입으로 인터페이스 사용:");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("인터페이스");
        arrayList.add("사용");

        // List 인터페이스를 매개변수로 받는 메서드 호출
        printList(arrayList); // ArrayList지만 List 인터페이스로 받음
    }

    /**
     * 나쁜 예: 매개변수가 너무 많은 메서드
     */
    private static void badMethodWithManyParameters(int p1, int p2, int p3, int p4,
                                                    String s1, String s2) {
        System.out.println("  많은 매개변수: " + p1 + ", " + p2 + ", " + p3 + ", " + p4
                + ", " + s1 + ", " + s2);
    }

    /**
     * 개선된 예: 매개변수를 그룹화한 메서드
     */
    private static void betterMethodWithGroupedParameters(Configuration config,
                                                          String s1, String s2) {
        System.out.println("  그룹화된 매개변수: " + config + ", " + s1 + ", " + s2);
    }

    /**
     * 매개변수 타입으로 인터페이스를 사용하는 메서드
     */
    private static void printList(List<String> list) {
        System.out.println("  리스트 내용: " + list);
    }

    /**
     * 전화번호부 클래스 - 메서드 이름 설계 예시
     */
    static class PhoneBook {
        private final List<Contact> contacts = new ArrayList<>();

        // 좋은 메서드 이름 예시
        public void addContact(String name, String phoneNumber) {
            contacts.add(new Contact(name, phoneNumber));
        }

        // 명확한 이름의 메서드
        public String findByName(String name) {
            for (Contact contact : contacts) {
                if (contact.name.equals(name)) {
                    return contact.phoneNumber;
                }
            }
            return "연락처를 찾을 수 없습니다.";
        }

        private static class Contact {
            private final String name;
            private final String phoneNumber;

            Contact(String name, String phoneNumber) {
                this.name = name;
                this.phoneNumber = phoneNumber;
            }
        }
    }

    /**
     * 매개변수를 그룹화한 설정 클래스
     */
    static class Configuration {
        private final int p1;
        private final int p2;
        private final int p3;
        private final int p4;

        public Configuration(int p1, int p2, int p3, int p4) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
        }

        @Override
        public String toString() {
            return "Config{" + p1 + ", " + p2 + ", " + p3 + ", " + p4 + "}";
        }
    }

    /**
     * 좌표를 나타내는 Point 클래스
     */
    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    /**
     * 크기를 나타내는 Dimension 클래스
     */
    static class Dimension {
        private final int width;
        private final int height;

        public Dimension(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return width + "x" + height;
        }
    }

    /**
     * 사각형 클래스 - 매개변수 그룹화 예시
     */
    static class Rectangle {
        private final Point position;
        private final Dimension size;

        // 개별 정수 4개보다 의미 있는 객체 2개를 받는 것이 좋음
        public Rectangle(Point position, Dimension size) {
            this.position = Objects.requireNonNull(position);
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public String toString() {
            return "위치: " + position + ", 크기: " + size;
        }
    }
}
