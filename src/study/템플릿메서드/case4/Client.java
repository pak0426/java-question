package study.템플릿메서드.case4;

public class Client {
    public static void main(String[] args) {
        System.out.println("커피 제조!");
        Drink drinkCoffee = new Coffee();
        drinkCoffee.makeDrink();

        System.out.println();
        System.out.println("티 제조!");
        Drink drinkTea = new Tea();
        drinkTea.makeDrink();
    }
}
