package study.생각하라_객체지향처럼.인터페이스;

import study.생각하라_객체지향처럼.Barista;
import study.생각하라_객체지향처럼.Menu;

public interface ICustomer {
    void order(String menuName, Menu menu, Barista barista);
}
