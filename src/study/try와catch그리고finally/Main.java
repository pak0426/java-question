package study.try와catch그리고finally;

public class Main {
    protected static void main(String[] args) {
//        test();
        testException();
    }

    public static void test() {
        try {
            System.out.println("시작!!!");

            return;
            // System.out.println("리턴 후?!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("예외로 왔습니다!");
        }
        finally {
            System.out.println("finally 입니다!!");
        }
    }

    public static void testException() {
        try {
            System.out.println("시작!!!");
            throw new IllegalAccessError("예외 발생시키기!!");
            // System.out.println("리턴 후?!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("e = " + e);
        }
        finally {
            System.out.println("finally 입니다!!");
        }
    }
}
