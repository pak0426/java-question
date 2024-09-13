package study.effective.item19;

/**
 * 이 클래스는 상속을 위해 설계되었습니다.
 * 하위 클래스에서 재정의할 수 있는 메서드: calculateArea()
 */
class Shape {
    private String name;

    /**
     * 도형의 이름을 설정합니다.
     * 이 메서드는 final이므로 하위 클래스에서 오버라이드할 수 없습니다.
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * 도형의 이름을 반환합니다.
     * 이 메서드는 final이므로 하위 클래스에서 오버라이드할 수 없습니다.
     */
    public final String getName() {
        return name;
    }

    /**
     * 도형의 면적을 계산합니다.
     * 이 메서드는 하위 클래스에서 반드시 구현해야 합니다.
     * @return 도형의 면적
     */
    protected double calculateArea() {
        throw new UnsupportedOperationException("하위 클래스에서 구현해야 합니다.");
    }

    /**
     * 도형의 정보를 출력합니다.
     * 이 메서드는 내부적으로 calculateArea()를 호출합니다.
     * 하위 클래스에서 calculateArea()를 오버라이드할 경우,
     * 이 메서드의 동작이 변경될 수 있습니다.
     */
    public void printInfo() {
        System.out.println("도형 이름: " + getName());
        System.out.println("도형 면적: " + calculateArea());
    }
}

/**
 * Shape 클래스를 상속받아 구현한 Circle 클래스
 */
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        setName("원");
    }

    @Override
    protected double calculateArea() {
        return Math.PI * radius * radius;
    }
}

/**
 * 상속을 허용하지 않는 클래스의 예
 */
final class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

public class Main {
    public static void main(String[] args) {
        // Shape을 상속받은 Circle 사용
        Circle circle = new Circle(5);
        circle.printInfo();

        // 상속이 금지된 Rectangle 사용
        Rectangle rectangle = new Rectangle(4, 5);
        System.out.println("직사각형 면적: " + rectangle.getArea());
    }
}
