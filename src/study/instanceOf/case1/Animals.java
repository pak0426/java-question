package study.instanceOf.case1;

public class Animals {
    public static void doSound(Animals animals) {
        if (animals instanceof Dog) {
            Dog dog = (Dog) animals;
            dog.sound();
        } else if (animals instanceof Cat) {
            Cat cat = (Cat) animals;
            cat.sound();
        }
        else {
            System.out.println("noting!");
        }
    }
}
