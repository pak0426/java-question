package study.IOC와DI.case3;

public class ChickenBurgerRecipe implements BurgerRecipe {
    @Override
    public Burger newBurger() {
        return new ChickenBurger();
    }

    static class ChickenBurger extends Burger {

    }
}


