package day11;

public class Main3 {
    public static void main(String args[]) {
        final int lengths = 50000;

        long st1 = System.currentTimeMillis();

        String str = "";
        for (int i = 0; i < lengths; i++) {
            str += "*";
        }

        long et1 = System.currentTimeMillis();

        long st2 = System.currentTimeMillis();

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < lengths; i++) {
            stringBuffer.append("*");
        }

        long et2 = System.currentTimeMillis();

        long st3 = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lengths; i++) {
            stringBuilder.append("*");
        }

        long et3 = System.currentTimeMillis();

        long duration1 = et1 - st1;
        long duration2 = et2 - st2;
        long duration3 = et3 - st3;

        System.out.println("duration1 = " + duration1);
        System.out.println("duration2 = " + duration2);
        System.out.println("duration3 = " + duration3);
    }
}
