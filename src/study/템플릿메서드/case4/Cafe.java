package study.템플릿메서드.case4;

abstract class Drink {
    public final void makeDrink() {
        boilWater();
        addItem();
        pourInCup();
        if (wantOtherItem()) {
            addOtherItem();
        }
    }

    private void boilWater() {
        System.out.println("물을 끓임");
    };
    protected abstract void addItem();
    protected abstract void addOtherItem();
    private void pourInCup() {
        System.out.println("컵에 따른다.");
    };

    protected boolean wantOtherItem() {
        return false;
    };

}

class Coffee extends Drink {

    @Override
    public void addItem() {
        System.out.println("에스프레소 추가");
    }

    @Override
    public void addOtherItem() {
        System.out.println("설탕과 우유를 추가");
    }

    protected boolean wantOtherItem() {
        return true;
    }
}

class Tea extends Drink {

    @Override
    public void addItem() {
        System.out.println("티백 추가");
    }

    @Override
    public void addOtherItem() {

    }
}

