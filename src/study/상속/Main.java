package study.상속;

public class Main {
    public static void main(String[] args) {
        Penguin pororo = new Penguin();
        pororo.name = "뽀로로";
        pororo.habitat = "남극";

        pororo.showName();
        pororo.showHabitat();

        Animals pingu = new Penguin();
        pingu.name = "핑구";
//        pingu.habitat = "핑구집"; -> Animals의 참조변수임

        pingu.showName();
//        pingu.showHabitat(); -> Animals의 참조변수임

//        Penguin happy = new Animals(); -> Penguin happy = (Penguin) new Animals();
        pingu.move();

        Animals animals = new Animals();
        animals.name = "포유류";
        animals.showName();
        animals.move();

//        Penguin penguin = new Animals(); -> 자식은 부모가 될 수 없다.
    }
}
