package day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2 {

    public static void main(String args[]) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();
        for(int i=0; i < 10000; i++) {
            arrayList.add(0, "item" + i);
        }
        long endTime = System.nanoTime();

        System.out.println("ArrayList 삽입 소요시간: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        for(int i=0; i < 10000; i++) {
            linkedList.add(0, "item" + i);
        }
        endTime = System.nanoTime();

        System.out.println("LinkedList 삽입 소요시간: " + (endTime - startTime) + "ns");
    }
}
