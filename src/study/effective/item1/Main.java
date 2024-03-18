package study.effective.item1;

public class Main {
    public static void main(String[] args) {
        // 정적 팩터리 메서드를 사용하여 객체 생성
        Person student = Person.createStudent("Alice", 20);
        Person teacher = Person.createTeacher("Bob", 35);

        System.out.println(student);
        System.out.println(teacher);
    }

    static class Person {
        private String name;
        private int age;
        private String role;

        // private 생성자
        private Person(String name, int age, String role) {
            this.name = name;
            this.age = age;
            this.role = role;
        }

        // 학생을 생성하는 정적 팩터리 메서드
        public static Person createStudent(String name, int age) {
            return new Person(name, age, "Student");
        }

        // 교사를 생성하는 정적 팩터리 메서드
        public static Person createTeacher(String name, int age) {
            return new Person(name, age, "Teacher");
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", role='" + role + '\'' +
                    '}';
        }
    }
}
