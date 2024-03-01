package study.equals와hashCode;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Person personA = new Person(10, "A");
        Person personA2 = new Person(10, "A");

        System.out.println(personA.equals(personA2)); // false

        Map<Person, String> personMap = new HashMap<>();
        personMap.put(personA, "hello A");

        String getPersonA = personMap.get(personA2);
        System.out.println(getPersonA);

        System.out.println("==========");

        Animal animalA = new Animal(10, "tiger");
        Animal animalB = new Animal(10, "tiger");

        System.out.println(animalA.equals(animalB));

        Map<Animal, String> animalMap = new HashMap<>();
        animalMap.put(animalA, "tiger!!");

        String getAnimalA = animalMap.get(animalB);

        System.out.println(getAnimalA);
    }
}
