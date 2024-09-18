package study.effective.item23;

public class Main {
    public static void main(String[] args) {
        // 태그 달린 클래스 사용 (좋지 않은 방식)
        Figure badCircle = new Figure(Figure.Shape.CIRCLE);
        badCircle.radius = 5;
        System.out.println("Bad Circle Area: " + badCircle.area());

        Figure badRectangle = new Figure(Figure.Shape.RECTANGLE);
        badRectangle.length = 4;
        badRectangle.width = 5;
        System.out.println("Bad Rectangle Area: " + badRectangle.area());

        // 클래스 계층구조 사용 (좋은 방식)
        Shape goodCircle = new Circle(5);
        System.out.println("Good Circle Area: " + goodCircle.area());

        Shape goodRectangle = new Rectangle(4, 5);
        System.out.println("Good Rectangle Area: " + goodRectangle.area());
    }
}

// 태그 달린 클래스 (좋지 않은 방식)
class Figure {
    enum Shape { RECTANGLE, CIRCLE }

    final Shape shape;

    // 사각형일 때만 사용하는 필드
    double length;
    double width;

    // 원일 때만 사용하는 필드
    double radius;

    Figure(Shape shape) {
        this.shape = shape;
    }

    double area() {
        switch(shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}

// 클래스 계층구조 (좋은 방식)
abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends Shape {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}