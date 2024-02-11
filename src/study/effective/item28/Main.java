package study.effective.item28;

public class Main {
    public static void main(String args[]) {
        Object[] objects = new String[1];
        objects[0] = "hi";

        objects[0] = Integer.valueOf(42);
    }
}
