package study.템플릿메서드.case3;

class Coffee {
    public void makeBeverage() {
        boilWater();
        addEspresso();
        pourInCup();
        addSugarAndMilk();
    }

    public void boilWater() {
        System.out.println("물을 끓임");
    };
    public void addEspresso() {
        System.out.println("에스프레스 추가");
    };
    public void pourInCup() {
        System.out.println("컵에 따름");
    };

    public void addSugarAndMilk() {
        System.out.println("설탕과 우유를 넣음");
    };
}

class Tea {
    public void makeBeverage() {
        boilWater();
        addTeaBag();
        pourInCup();
    }

    public void boilWater() {
        System.out.println("물을 끓임");
    };
    public void addTeaBag() {
        System.out.println("티백을 넣음");
    };
    public void pourInCup() {
        System.out.println("컵에 따름");
    };
}

