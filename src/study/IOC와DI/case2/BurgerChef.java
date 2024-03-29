package study.IOC와DI.case2;

class BurgerChef {
    private BurgerRecipe burgerRecipe;

    public BurgerChef() {
        burgerRecipe = new ChickenBurgerRecipe();
    }
}
