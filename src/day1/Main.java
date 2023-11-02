package day1;

public class Main {
    public static void main(String args[]) {
        String str1 = "Hello";
        String str2 = "Hello";

        System.out.println(str1 == str2); // true
        System.out.println(str1.equals(str2)); // true

        String s1 = new String("hi");
        String s2 = new String("hi");

        System.out.println(s1 == s2); // false -> 객체의 주소값을 비교하기 떄문
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.hashCode() == s2.hashCode()); // false

        Man man1 = new Man("hmmini");
        Man man2 = new Man("hmmini");

        System.out.println(man1.equals(man2)); //false -> 객체의 주소값을 비교하기 떄문
        System.out.println(man1.hashCode());
        System.out.println(man2.hashCode());
        System.out.println(man1.hashCode() == man2.hashCode());

        Woman woman1 = new Woman("mini");
        Woman woman2 = new Woman("mini");

        System.out.println(woman1.equals(woman2)); //true -> overiding으로 재정의하였음
        System.out.println(woman1.hashCode());
        System.out.println(woman2.hashCode());
        System.out.println(woman1.hashCode() == woman2.hashCode()); //true -> overiding으로 재정의하였음
    }
}
