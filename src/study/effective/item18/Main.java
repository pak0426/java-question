package study.effective.item18;

import java.util.*;

// 기존의 클래스
class InstrumentedSet<E> implements Set<E> {
    private final Set<E> s;
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        this.s = s;
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return s.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return s.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    // Set 인터페이스의 나머지 메서드들은 s에 위임
    @Override public int size() { return s.size(); }
    @Override public boolean isEmpty() { return s.isEmpty(); }
    @Override public boolean contains(Object o) { return s.contains(o); }
    @Override public Iterator<E> iterator() { return s.iterator(); }
    @Override public Object[] toArray() { return s.toArray(); }
    @Override public <T> T[] toArray(T[] a) { return s.toArray(a); }
    @Override public boolean remove(Object o) { return s.remove(o); }
    @Override public boolean containsAll(Collection<?> c) { return s.containsAll(c); }
    @Override public boolean removeAll(Collection<?> c) { return s.removeAll(c); }
    @Override public boolean retainAll(Collection<?> c) { return s.retainAll(c); }
    @Override public void clear() { s.clear(); }
}

public class Main {
    public static void main(String[] args) {
        // HashSet을 감싸는 InstrumentedSet 생성
        Set<String> set = new InstrumentedSet<>(new HashSet<>());

        // 요소 추가
        set.add("A");
        set.add("B");
        set.add("C");

        // 여러 요소 한 번에 추가
        set.addAll(Arrays.asList("D", "E", "F"));

        // 추가된 요소 수 출력
        System.out.println("추가된 요소 수: " + ((InstrumentedSet<String>)set).getAddCount());
        System.out.println("실제 Set의 크기: " + set.size());
    }
}
