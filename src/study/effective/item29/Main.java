package study.effective.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        // 제네릭을 사용하지 않은 스택
        OldStack oldStack = new OldStack();
        oldStack.push("Hello");
        String item = (String) oldStack.pop(); // 형변환 필요
        System.out.println("Old stack item: " + item);

        // 제네릭을 사용한 스택
        Stack<String> stack = new Stack<>();
        stack.push("World");
        String genericItem = stack.pop(); // 형변환 불필요
        System.out.println("Generic stack item: " + genericItem);
    }
}

// 제네릭을 사용하지 않은 스택 구현
class OldStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public OldStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}

// 제네릭을 사용한 스택 구현
class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
