package study.템플릿메서드.case3;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.makeBeverage();

        Tea tea = new Tea();
        tea.makeBeverage();
    }
}
