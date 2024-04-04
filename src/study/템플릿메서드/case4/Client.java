package study.템플릿메서드.case4;

public class Client {
    public static void main(String[] args) {
        Drink drinkCoffee = new Coffee();
        drinkCoffee.makeDrink();

        Drink drinkTea = new Tea();
        drinkTea.makeDrink();
    }
}
