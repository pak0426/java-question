package study.effective.item17;

// 불변 클래스 예제
final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        ImmutablePerson person1 = new ImmutablePerson("Alice", 30);
        System.out.println("Person 1: " + person1);

        // 새로운 객체를 생성해야 "변경"할 수 있음
        ImmutablePerson person2 = new ImmutablePerson("Bob", 25);
        System.out.println("Person 2: " + person2);

        // person1의 값은 변경할 수 없음
        // 아래 라인은 컴파일 에러를 발생시킴
        // person1.setAge(31);  // 이런 메서드는 존재하지 않음

        // 객체의 상태를 "변경"하려면 새 객체를 생성해야 함
        ImmutablePerson olderAlice = new ImmutablePerson(person1.getName(), person1.getAge() + 1);
        System.out.println("Older Alice: " + olderAlice);
    }
}
