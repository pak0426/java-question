package study.effective.item16;

public class Main {
    public static void main(String[] args) {
        // 잘못된 방식: public 필드를 직접 노출
        BadPoint badPoint = new BadPoint();
        badPoint.x = 10;
        badPoint.y = 20;
        System.out.println("Bad Point: (" + badPoint.x + ", " + badPoint.y + ")");

        // 올바른 방식: private 필드와 접근자 메서드 사용
        GoodPoint goodPoint = new GoodPoint(10, 20);
        System.out.println("Good Point: (" + goodPoint.getX() + ", " + goodPoint.getY() + ")");

        // 접근자 메서드를 통한 부가적인 동작 예시
        goodPoint.setX(30);
        System.out.println("Updated Good Point: (" + goodPoint.getX() + ", " + goodPoint.getY() + ")");
    }
}

// 잘못된 방식의 클래스
class BadPoint {
    public double x;
    public double y;
}

// 올바른 방식의 클래스
class GoodPoint {
    private double x;
    private double y;

    public GoodPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        // 여기서 부가적인 동작 수행 가능
        if (x < 0) {
            throw new IllegalArgumentException("X coordinate cannot be negative");
        }
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        // 여기서 부가적인 동작 수행 가능
        if (y < 0) {
            throw new IllegalArgumentException("Y coordinate cannot be negative");
        }
        this.y = y;
    }
}
