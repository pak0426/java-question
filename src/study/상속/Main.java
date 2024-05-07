package study.상속;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Penguin pororo = new Penguin();
        pororo.name = "뽀로로";
        pororo.habitat = "남극";

        pororo.showName();
        pororo.showHabitat();

        System.out.println();

        Animals pingu = new Penguin();
        pingu.name = "핑구";
//        pingu.habitat = "핑구집"; -> Animals의 참조변수임

        pingu.showName();
//        pingu.showHabitat(); -> Animals의 참조변수임

//        Penguin happy = new Animals(); -> Penguin happy = (Penguin) new Animals();
        pingu.move();

        System.out.println();

        Animals animals = new Animals();
        animals.name = "포유류";
        animals.showName();
        animals.move();

        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("000");


        int asInt = list.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
        System.out.println(asInt);

        List<String> list2 = new ArrayList<>();
        int asInt2 = list2.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
        System.out.println(asInt);



//        Penguin penguin = new Animals(); -> 자식은 부모가 될 수 없다.
    }
}
