package day3;

public class Main {
    public static void main(String args[]) {
        Person person = new Person("hmmini", 28);

        String name = person.getName();
        int age = person.getAge();
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        person.sayHello();

        person.setName("mini");
        person.setAge(29);
        person.sayHello();
    }
}
