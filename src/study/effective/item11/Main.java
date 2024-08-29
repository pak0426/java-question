package study.effective.item11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map<Person, String> personMap = new HashMap<>();

        Person person1 = new Person("Hmmini", 29);
        personMap.put(person1, "Kind");

        // 같은 이름과 나이를 가진 새로운 Person 객체 생성
        Person person2 = new Person("Hmmini", 29);

        // hashCode를 재정의하지 않았다면 null을 반환
        // hashCode를 재정의했다면 "Software Engineer"를 반환
        System.out.println(personMap.get(person2));

        // equals 메서드 테스트
        System.out.println("person1.equals(person2): " + person1.equals(person2));

        // hashCode 메서드 테스트
        System.out.println("person1 hashCode: " + person1.hashCode());
        System.out.println("person2 hashCode: " + person2.hashCode());
    }
}

class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
