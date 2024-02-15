package study.생각하라_객체지향처럼;

import study.생각하라_객체지향처럼.인터페이스.ICustomer;

import java.util.Optional;

public class Customer implements ICustomer {
    @Override
    public void order(String menuName, Menu menu, Barista barista) {
        Optional<MenuItem> menuItem = menu.choose(menuName);
        if (!menuItem.isPresent()) {
            return;
        }
        Coffee coffee = barista.makeCoffee(menuItem.get());
    }
}