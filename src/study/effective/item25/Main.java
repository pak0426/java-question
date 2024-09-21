package study.effective.item25;

public class Main {
    public static void main(String[] args) {
        // 잘못된 예: 한 파일에 여러 톱레벨 클래스를 정의
        class Utensil {
            static final String NAME = "pan";
        }

        class Dessert {
            static final String NAME = "cake";
        }

        System.out.println("잘못된 예 결과:");
        System.out.println(Utensil.NAME + " " + Dessert.NAME);

        // 올바른 예: 정적 멤버 클래스 사용
        class Meal {
            private Meal() {} // 인스턴스화 방지

            static class Utensil {
                static final String NAME = "fork";
            }

            static class Dessert {
                static final String NAME = "ice cream";
            }
        }

        System.out.println("\n올바른 예 결과 (정적 멤버 클래스 사용):");
        System.out.println(Meal.Utensil.NAME + " " + Meal.Dessert.NAME);
    }
}
