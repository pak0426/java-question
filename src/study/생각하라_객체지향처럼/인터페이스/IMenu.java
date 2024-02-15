package study.생각하라_객체지향처럼.인터페이스;

import study.생각하라_객체지향처럼.MenuItem;

import java.util.Optional;

public interface IMenu {
    public Optional<MenuItem> choose(String name);
}
