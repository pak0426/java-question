package study.effective.item12;

public class Main {
    public static void main(String[] args) {
        // toString을 재정의한 클래스의 인스턴스 생성
        Person person = new Person("홍길동", 30);

        // toString 메서드 호출
        System.out.println(person);

        // toString을 재정의하지 않은 클래스의 인스턴스 생성
        DefaultToString defaultObj = new DefaultToString();

        // 기본 toString 메서드 호출
        System.out.println(defaultObj);
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
    public String toString() {
        return String.format("Person(name=%s, age=%d)", name, age);
    }

    // toString이 반환한 값에 포함된 정보를 얻어올 수 있는 API
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class DefaultToString {
    // toString을 재정의하지 않음
}
