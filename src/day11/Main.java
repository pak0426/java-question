package day11;

public class Main {
    public static void main(String argsp[]) {
        String str1 = "hello";
        String str2 = "hello";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("hello");

        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));

        String sb_str1 = sb1.toString();
        String sb_str2 = sb2.toString();

        System.out.println(sb_str1 == sb_str2);
        System.out.println(sb_str1.equals(sb_str2));
    }
}
