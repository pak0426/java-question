package day4;

public class Static {
    public static String staticStr = "Hello, I'm static string";
    public String str = "Hello, I'm string";

    public static void staticMethod() {
        System.out.println("Hello I'm static method");
        System.out.println(staticStr);
        //System.out.println(str); //Non-static field 'str' cannot be referenced from a static context
    }

    public void method() {
        System.out.println("Hello I'm method");
        System.out.println(staticStr);
        System.out.println(str);
    }
}
