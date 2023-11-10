package day2;

public class Overriding {
    public static void main(String args[]) {
        Parent parent = new Parent();
        parent.print();
        parent.plus(10, 20);
        parent.multiple(10, 20, 30);
        parent.division(10, 20, "부모 메서드에서 나누기");

        System.out.println();

        Child child = new Child();
        child.print();
        child.plus(1, 2);
        child.multiple(1, 2, 3);
        child.division(1, 2, "자식 메서드에서 나누기");
    }
}
