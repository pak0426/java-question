package study.IOC와DI.case2;

public class ChickenBurgerRecipe implements BurgerRecipe {
    @Override
    public Burger newBurger() {
        return new ChickenBurger();
    }

    static class ChickenBurger extends Burger {

    }
}


