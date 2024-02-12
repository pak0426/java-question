package study.접근제어자.case1;

public class Main {
    public static void main(String args[]) {
        Snack snack = new Snack("chips");
        String name = snack.getName();
        int price = snack.price;
        String company = snack.company;
        System.out.println("name = " + name);
    }
}
