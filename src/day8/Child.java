package day8;

public class Child extends Parent{
    @Override
    public void overrideMethod() {
        super.overrideMethod();
    }

    @Deprecated
    public void deprecatedMethod() {
        super.deprecatedMethod();
    }

    @SuppressWarnings("all")
    public void supressWarningsMethod() {
        System.out.println("hello");
    }

    @MyAnnotation
    public void customTest() {
        System.out.println("custom hello!");
    }

    @MyAnnotation(value = "change custom!")
    public void changeCustomTest() {
        System.out.println("change!!!");
    }
}
