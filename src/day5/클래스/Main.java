package day5.클래스;

public class Main {
    public static void main(String[] args) {

        int day = Week.MONDAY;

        if (Week.MONDAY == Month.JANUARY) {
            System.out.println(Week.MONDAY);
            System.out.println(Month.JANUARY);
            day = Month.JANUARY;
        }

        switch (day) {
            case Week.MONDAY:
                System.out.println(day);
                break;
            case Week.TUESDAY:
                System.out.println(day);
                break;
            case Week.WEDNESDAY:
                System.out.println(day);
                break;
        }

        WeekInstance week = new WeekInstance();
        if (week == WeekInstance.MONDAY) {
            System.out.println("Same");
        }
        else {
            System.out.println("Not same");
        }
    }
}
