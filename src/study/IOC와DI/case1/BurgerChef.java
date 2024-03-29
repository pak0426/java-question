package study.IOC와DI.case1;

class BurgerChef {
    private ChickenBurgerRecipe chickenBurgerRecipe;

    public BurgerChef() {
        chickenBurgerRecipe = new ChickenBurgerRecipe();
    }
}
