package study.effective.item7;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        // 스택 예제
        Stack stack = new Stack();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println(stack.pop());  // Third
        System.out.println(stack.pop());  // Second

        // 캐시 예제
        WeakHashMap<UniqueKey, String> cache = new WeakHashMap<>();
        UniqueKey key1 = new UniqueKey(1);
        UniqueKey key2 = new UniqueKey(2);

        cache.put(key1, "Value 1");
        cache.put(key2, "Value 2");

        System.out.println(cache.get(key1));  // Value 1
        key1 = null;  // key1에 대한 강한 참조 제거
        System.gc();  // 가비지 컬렉션 실행 (실제로는 이렇게 직접 호출하지 않음)
        System.out.println(cache.size());  // 1 (key1에 대한 항목이 제거됨)
    }
}

// 메모리 누수가 있는 스택 구현
class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        return elements[--size];  // 메모리 누수 발생 지점
//    }

    // 메모리 누수를 해결한 개선된 pop 메서드
     public Object pop() {
         if (size == 0)
             throw new EmptyStackException();
         Object result = elements[--size];
         elements[size] = null;  // 다 쓴 참조 해제
         return result;
     }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}

class UniqueKey {
    private int id;

    public UniqueKey(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UniqueKey uniqueKey = (UniqueKey) obj;
        return id == uniqueKey.id;
    }
}
