package study.생각하라_객체지향처럼;

import study.생각하라_객체지향처럼.인터페이스.IBarista;

public class Barista implements IBarista {
    @Override
    public Coffee makeCoffee(MenuItem menuItem) {
        Coffee coffee = new Coffee(menuItem);
        return coffee;
    }
}
