package study.effective.item6;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class Main {
    // 1. String 객체의 불필요한 생성 피하기
    public static void stringExample() {
        String s1 = "bikini";  // 좋음: 문자열 리터럴을 사용
        String s2 = new String("bikini");  // 나쁨: 불필요한 객체 생성

        System.out.println("s1 == s2: " + (s1 == s2));  // false
        System.out.println("s1.equals(s2): " + s1.equals(s2));  // true
    }

    // 2. Boolean 객체의 불필요한 생성 피하기
    public static void booleanExample() {
        Boolean b1 = Boolean.valueOf(true);  // 좋음: 캐시된 인스턴스 반환
        Boolean b2 = new Boolean(true);  // 나쁨: 항상 새 인스턴스 생성

        System.out.println("b1 == b2: " + (b1 == b2));  // false
        System.out.println("b1.equals(b2): " + b1.equals(b2));  // true
    }

    // 3. 비용이 큰 객체를 재사용하기
    private static final Calendar GMT_CALENDAR = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    public static long getDateDifference(Date d1, Date d2) {
        // GMT_CALENDAR를 재사용하여 불필요한 객체 생성을 피함
        GMT_CALENDAR.setTime(d1);
        long timeInMillis1 = GMT_CALENDAR.getTimeInMillis();
        GMT_CALENDAR.setTime(d2);
        long timeInMillis2 = GMT_CALENDAR.getTimeInMillis();

        return Math.abs(timeInMillis2 - timeInMillis1);
    }

    // 4. 정규표현식 패턴 객체 재사용하기
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        stringExample();
        booleanExample();

        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + 86400000);  // 1일 후
        System.out.println("Date difference: " + getDateDifference(d1, d2) + " milliseconds");

        System.out.println("Is 'XIV' a Roman numeral? " + isRomanNumeral("XIV"));
        System.out.println("Is 'XIIII' a Roman numeral? " + isRomanNumeral("XIIII"));
    }
}
