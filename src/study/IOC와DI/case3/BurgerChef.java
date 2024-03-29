package study.IOC와DI.case3;

class BurgerChef {
    private BurgerRecipe burgerRecipe;

    public BurgerChef(BurgerRecipe burgerRecipe) {
        this.burgerRecipe = burgerRecipe;
    }

    static class Main {
        public static void main(String[] args) {
            BurgerChef burgerChef1 = new BurgerChef(new ChickenBurgerRecipe());
            BurgerChef burgerChef2 = new BurgerChef(new BeefBurgerRecipe());
        }
    }
}
