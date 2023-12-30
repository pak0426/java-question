package day10;

import java.util.HashMap;

public class Main {
    public static void main(String args[]) {
        HashMap<Key, String> map = new HashMap<>();

        Key key = new Key("hello");
        map.put(key, "hello value");

        String value = map.get(key);

        System.out.println(value);
    }
}
