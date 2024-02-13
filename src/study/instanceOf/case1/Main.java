package study.instanceOf.case1;

public class Main {
    public static void main(String args[]) {
        Animals animals = new Animals();
        Dog dog = new Dog();
        Cat cat = new Cat();

        Animals.doSound(animals);
        Animals.doSound(dog);
        Animals.doSound(cat);
    }
}
