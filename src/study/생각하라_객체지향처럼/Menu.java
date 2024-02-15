package study.생각하라_객체지향처럼;

import study.생각하라_객체지향처럼.인터페이스.IMenu;

import java.util.List;
import java.util.Optional;

public class Menu implements IMenu {
    private List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public Optional<MenuItem> choose(String name) {
        return menuItems
                .stream()
                .filter(menuItem -> menuItem.getName().equals(name))
                .findFirst();
    }
}
