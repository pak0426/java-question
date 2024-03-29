package study.IOC와DI.case3;

public class BeefBurgerRecipe implements BurgerRecipe {
    @Override
    public Burger newBurger() {
        return new BeefBurger();
    }

    static class BeefBurger extends Burger {

    }
}


