package study.effective.item14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Comparable을 구현한 Person 클래스의 인스턴스 생성
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 30);
        Person p3 = new Person("Charlie", 20);

        // Person 객체들을 리스트에 추가
        List<Person> people = Arrays.asList(p1, p2, p3);

        // 정렬 전 출력
        System.out.println("정렬 전:");
        for (Person p : people) {
            System.out.println(p);
        }

        // Comparable 구현에 따라 정렬
        Collections.sort(people);

        // 정렬 후 출력
        System.out.println("\n정렬 후:");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        // 나이를 기준으로 비교
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
