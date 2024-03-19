package study.effective.item2;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder(12)
                .cheese(true)
                .pepperoni(true)
                .bacon(false)
                .build();

        System.out.println(pizza);

        Pizza vegetarianPizza = new Pizza.Builder(14)
                .cheese(true)
                .vegetable(true)
                .build();

        System.out.println(vegetarianPizza);
    }

    public static class Pizza {
        private final int size;
        private final boolean cheese;
        private final boolean pepperoni;
        private final boolean bacon;
        private final boolean vegetable;

        private Pizza(Builder builder) {
            size = builder.size;
            cheese = builder.cheese;
            pepperoni = builder.pepperoni;
            bacon = builder.bacon;
            vegetable = builder.vegetable;
        }

        public static class Builder {
            // 필수 매개변수
            private final int size;

            // 선택 매개변수 - 기본값으로 초기화
            private boolean cheese = false;
            private boolean pepperoni = false;
            private boolean bacon = false;
            private boolean vegetable = false;

            public Builder(int size) {
                this.size = size;
            }

            public Builder cheese(boolean value) {
                cheese = value;
                return this;
            }

            public Builder pepperoni(boolean value) {
                pepperoni = value;
                return this;
            }

            public Builder bacon(boolean value) {
                bacon = value;
                return this;
            }

            public Builder vegetable(boolean value) {
                vegetable = value;
                return this;
            }

            public Pizza build() {
                return new Pizza(this);
            }
        }

        @Override
        public String toString() {
            return "Pizza{" +
                    "size=" + size +
                    ", cheese=" + cheese +
                    ", pepperoni=" + pepperoni +
                    ", bacon=" + bacon +
                    ", vegetable=" + vegetable +
                    '}';
        }
    }
}
