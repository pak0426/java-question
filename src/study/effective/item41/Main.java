package study.effective.item41;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new Orange());
        fruits.add(new Banana());

        FruitProcessor processor = new FruitProcessor();
        processor.processFruits(fruits);
    }
}

// Marker interface
interface Peelable {}

class Fruit {
    String name;

    Fruit(String name) {
        this.name = name;
    }
}

class Apple extends Fruit {
    Apple() {
        super("Apple");
    }
}

class Orange extends Fruit implements Peelable {
    Orange() {
        super("Orange");
    }
}

class Banana extends Fruit implements Peelable {
    Banana() {
        super("Banana");
    }
}

class FruitProcessor {
    public void processFruits(List<Fruit> fruits) {
        for (Fruit fruit : fruits) {
            System.out.print("Processing " + fruit.name + ": ");
            if (fruit instanceof Peelable) {
                System.out.println("This fruit needs to be peeled before eating.");
                // Perform peeling operation
            } else {
                System.out.println("This fruit can be eaten without peeling.");
            }
        }
    }
}
