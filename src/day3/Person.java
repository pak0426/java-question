package day3;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("안녕하세요. 제 이름은 " + this.name + "이고, 제 나이는 " + age + "살입니다.");
    }
}
