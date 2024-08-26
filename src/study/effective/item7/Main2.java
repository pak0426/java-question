package study.effective.item7;

import java.util.WeakHashMap;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<UniqueKeys, String> cache = new WeakHashMap<>();
        UniqueKeys key1 = new UniqueKeys(1);
        UniqueKeys key2 = new UniqueKeys(2);

        cache.put(key1, "Value 1");
        cache.put(key2, "Value 2");

        System.out.println("Initial cache size: " + cache.size());  // 2

        key1 = null;  // key1에 대한 강한 참조 제거
        System.gc();  // 가비지 컬렉션 요청

        // 가비지 컬렉션이 실행될 시간을 주기 위해 잠시 대기
        Thread.sleep(100);

        System.out.println("Cache size after GC: " + cache.size());  // 1 또는 2

        // 여러 번 GC를 요청하고 대기
        for (int i = 0; i < 10; i++) {
            System.gc();
            Thread.sleep(100);
        }

        System.out.println("Final cache size: " + cache.size());  // 1

        // 남아있는 항목 확인
        for (UniqueKeys key : cache.keySet()) {
            System.out.println("Remaining key: " + key.getId());
        }
    }
}

class UniqueKeys {
    private int id;

    public UniqueKeys(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // hashCode와 equals 메서드는 이전과 동일
}
