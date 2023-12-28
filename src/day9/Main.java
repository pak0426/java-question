package day9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 10000; i++) {
            arrayList.add("item" + i);
            linkedList.add("item" + i);
        }

        long startTime = System.nanoTime();
        arrayList.remove(5000);
        long endTime = System.nanoTime();
        System.out.println("ArrayList 삭제 소요 시간: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        linkedList.remove(5000);
        endTime = System.nanoTime();

        System.out.println("LinkedList 삭제 소요 시간: " + (endTime - startTime) + "ns");
    }
}
