package day4;

public class Main {
    public static void main(String args[]) {
        System.out.println(Static.staticStr);
        //System.out.println(Static.str); //Non-static field 'str' cannot be referenced from a static context
        Static.staticMethod();

        Static staticInstance = new Static();
        System.out.println(staticInstance.str);
        staticInstance.method();
    }
}
