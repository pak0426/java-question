package study.effective.item10;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // 올바르게 equals를 재정의한 클래스 사용
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 1);

        System.out.println("올바른 equals 재정의:");
        System.out.println("p1.equals(p2) = " + p1.equals(p2));  // true
        System.out.println("p1.equals(p3) = " + p1.equals(p3));  // false

        // 잘못 재정의한 equals 사용
        ColorPoint cp1 = new ColorPoint(1, 2, "red");
        Point p = new Point(1, 2);

        System.out.println("\n잘못된 equals 재정의 (대칭성 위배):");
        System.out.println("cp1.equals(p) = " + cp1.equals(p));   // true
        System.out.println("p.equals(cp1) = " + p.equals(cp1));   // false
    }
}

// 올바르게 equals를 재정의한 클래스
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

// 잘못 재정의한 equals (대칭성 위배)
class ColorPoint extends Point {
    private final String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        if (!(o instanceof ColorPoint)) return o.equals(this);
        return super.equals(o) && ((ColorPoint) o).color.equals(color);
    }
}
