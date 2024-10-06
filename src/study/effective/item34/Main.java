package study.effective.item34;

public class Main {
    // 기존의 int 상수 방식 (사용하지 말 것)
    public static final int PIZZA_SMALL = 0;
    public static final int PIZZA_MEDIUM = 1;
    public static final int PIZZA_LARGE = 2;

    // 열거 타입 방식 (권장)
    public enum PizzaSize {
        SMALL(30), MEDIUM(40), LARGE(50);

        private final int diameter;

        PizzaSize(int diameter) {
            this.diameter = diameter;
        }

        public int getDiameter() {
            return diameter;
        }
    }

    public enum PizzaTopping {
        CHEESE, PEPPERONI, MUSHROOM, ONION
    }

    public static class Pizza {
        private final PizzaSize size;
        private final PizzaTopping topping;

        public Pizza(PizzaSize size, PizzaTopping topping) {
            this.size = size;
            this.topping = topping;
        }

        public int getPrice() {
            int basePrice;
            switch (size) {
                case SMALL:
                    basePrice = 10000;
                    break;
                case MEDIUM:
                    basePrice = 14000;
                    break;
                case LARGE:
                    basePrice = 18000;
                    break;
                default:
                    throw new AssertionError("Unknown pizza size: " + size);
            }

            // 토핑 추가 가격
            if (topping == PizzaTopping.CHEESE) {
                basePrice += 500;
            } else if (topping != PizzaTopping.PEPPERONI) {
                basePrice += 1000;
            }

            return basePrice;
        }

        @Override
        public String toString() {
            return size + " pizza with " + topping + " topping";
        }
    }

    public static void main(String[] args) {
        // 열거 타입 사용 예
        Pizza myPizza = new Pizza(PizzaSize.MEDIUM, PizzaTopping.PEPPERONI);
        System.out.println("My order: " + myPizza);
        System.out.println("Price: " + myPizza.getPrice() + " won");
        System.out.println("Pizza diameter: " + myPizza.size.getDiameter() + " cm");

        // 모든 피자 크기 출력
        System.out.println("\nAvailable pizza sizes:");
        for (PizzaSize size : PizzaSize.values()) {
            System.out.println(size + " (" + size.getDiameter() + " cm)");
        }

        // 모든 토핑 출력
        System.out.println("\nAvailable toppings:");
        for (PizzaTopping topping : PizzaTopping.values()) {
            System.out.println(topping);
        }
    }
}