package study.effective.item21;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 기존 구현체 사용
        OldCollection oldCollection = new OldCollection();
        oldCollection.add("항목1");
        oldCollection.remove("항목1");

        // 새로운 디폴트 메서드를 활용한 구현체 사용
        NewCollection newCollection = new NewCollection();
        newCollection.add("항목1");
        newCollection.add("항목2");
        newCollection.removeIf(item -> item.equals("항목1"));

        System.out.println("NewCollection 크기: " + newCollection.size());
    }
}

interface SimpleCollection {
    void add(String item);
    void remove(String item);
    int size();

    // Java 8 이후 추가된 디폴트 메서드
    default void removeIf(Predicate<String> filter) {
        Objects.requireNonNull(filter);
        for (Iterator<String> it = iterator(); it.hasNext(); ) {
            if (filter.test(it.next())) {
                it.remove();
            }
        }
    }

    Iterator<String> iterator();
}

class OldCollection implements SimpleCollection {
    private List<String> items = new ArrayList<>();

    public void add(String item) {
        items.add(item);
    }

    public void remove(String item) {
        items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public Iterator<String> iterator() {
        return items.iterator();
    }
}

class NewCollection implements SimpleCollection {
    private Set<String> items = new HashSet<>();

    public void add(String item) {
        items.add(item);
    }

    public void remove(String item) {
        items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public Iterator<String> iterator() {
        return items.iterator();
    }
}
