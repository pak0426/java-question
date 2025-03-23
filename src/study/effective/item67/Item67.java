package study.effective.item67;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Item67 {
    public static void main(String[] args) {
        // 1. 성급한 최적화의 예
        PrematureOptimization po = new PrematureOptimization();
        po.comparePerformance();

        // 2. 아키텍처 수준 최적화 (좋은 예)
        ArchitecturalOptimization ao = new ArchitecturalOptimization();
        ao.demonstrateOptimization();

        // 3. 프로파일링 기반 최적화 (권장 방식)
        ProfileBasedOptimization pbo = new ProfileBasedOptimization();
        pbo.optimizeWithProfiling();
    }
}

// 1. 성급한 최적화 예시
class PrematureOptimization {

    // 가독성 좋은 일반 구현
    public String concatenateNormal(List<String> items) {
        StringBuilder result = new StringBuilder();
        for (String item : items) {
            result.append(item);
        }
        return result.toString();
    }

    // "최적화된" 구현 - 실제로는 불필요하고 가독성만 해침
    public String concatenateOverOptimized(List<String> items) {
        int totalLength = 0;
        for (String s : items) {
            totalLength += s.length();
        }

        char[] chars = new char[totalLength];
        int offset = 0;
        for (String s : items) {
            for (int i = 0; i < s.length(); i++) {
                chars[offset++] = s.charAt(i);
            }
        }
        return new String(chars);
    }

    public void comparePerformance() {
        List<String> testData = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            testData.add("item" + i);
        }

        // 워밍업
        for (int i = 0; i < 5; i++) {
            concatenateNormal(testData);
            concatenateOverOptimized(testData);
        }

        // 성능 측정
        long startTime = System.nanoTime();
        String normal = concatenateNormal(testData);
        long normalTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        String optimized = concatenateOverOptimized(testData);
        long optimizedTime = System.nanoTime() - startTime;

        System.out.println("성급한 최적화 비교:");
        System.out.println("일반 구현 실행 시간: " + TimeUnit.NANOSECONDS.toMillis(normalTime) + "ms");
        System.out.println("과도 최적화 구현 실행 시간: " + TimeUnit.NANOSECONDS.toMillis(optimizedTime) + "ms");
        System.out.println("결과물 동일 여부: " + normal.equals(optimized));
        System.out.println("교훈: 성급한 최적화는 가독성/유지보수성을 해치고, 실제로 더 느릴 수 있음\n");
    }
}

// 2. 아키텍처 수준의 최적화 (좋은 예)
class ArchitecturalOptimization {

    // 비효율적인 설계: O(n) 탐색이 필요
    static class InefficientDesign {
        private List<User> users = new ArrayList<>();

        public void addUser(User user) {
            users.add(user);
        }

        public User findById(int id) {
            for (User user : users) {  // O(n) 선형 탐색
                if (user.id == id) {
                    return user;
                }
            }
            return null;
        }
    }

    // 효율적인 설계: O(1) 탐색
    static class EfficientDesign {
        private Map<Integer, User> usersById = new HashMap<>();

        public void addUser(User user) {
            usersById.put(user.id, user);
        }

        public User findById(int id) {
            return usersById.get(id);  // O(1) 해시맵 조회
        }
    }

    static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public void demonstrateOptimization() {
        InefficientDesign inefficient = new InefficientDesign();
        EfficientDesign efficient = new EfficientDesign();

        // 데이터 준비
        for (int i = 0; i < 100000; i++) {
            User user = new User(i, "User" + i);
            inefficient.addUser(user);
            efficient.addUser(user);
        }

        // 성능 측정
        long startTime = System.nanoTime();
        User user1 = inefficient.findById(99999);  // 최악의 경우
        long inefficientTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        User user2 = efficient.findById(99999);
        long efficientTime = System.nanoTime() - startTime;

        System.out.println("아키텍처 수준 최적화 비교:");
        System.out.println("비효율적 설계 조회 시간: " + TimeUnit.NANOSECONDS.toMicros(inefficientTime) + "μs");
        System.out.println("효율적 설계 조회 시간: " + TimeUnit.NANOSECONDS.toMicros(efficientTime) + "μs");
        System.out.println("성능 향상: " + inefficientTime / (double)efficientTime + "배");
        System.out.println("교훈: 설계부터 적절한 자료구조와 알고리즘을 선택하는 것이 중요\n");
    }
}

// 3. 프로파일링 기반 최적화 (권장 방식)
class ProfileBasedOptimization {
    private static final int COUNT = 1000000;

    // 최적화 전 코드
    public long sumBefore() {
        long sum = 0;
        for (int i = 0; i < COUNT; i++) {
            sum += calculateExpensive(i);  // 비용이 큰 계산
        }
        return sum;
    }

    // 프로파일링 후 핫스팟 최적화
    public long sumAfter() {
        // 자주 사용되는 계산 결과를 캐시
        Map<Integer, Long> cache = new HashMap<>();

        long sum = 0;
        for (int i = 0; i < COUNT; i++) {
            // 계산 결과 캐싱
            Long cached = cache.get(i % 100);  // 실제 상황에서는 입력값 변화가 적다고 가정
            if (cached != null) {
                sum += cached;
            } else {
                long result = calculateExpensive(i);
                cache.put(i % 100, result);
                sum += result;
            }
        }
        return sum;
    }

    private long calculateExpensive(int n) {
        // 비용이 큰 계산 시뮬레이션
        return (long) Math.pow(n % 10, 2);
    }

    public void optimizeWithProfiling() {
        // 프로파일링 단계 (실제로는 전문 도구 사용)
        System.out.println("프로파일링 단계 (시뮬레이션):");

        // 최적화 전 성능 측정
        long startTime = System.nanoTime();
        long result1 = sumBefore();
        long beforeTime = System.nanoTime() - startTime;

        // 최적화 후 성능 측정
        startTime = System.nanoTime();
        long result2 = sumAfter();
        long afterTime = System.nanoTime() - startTime;

        System.out.println("프로파일링 기반 최적화 비교:");
        System.out.println("최적화 전 실행 시간: " + TimeUnit.NANOSECONDS.toMillis(beforeTime) + "ms");
        System.out.println("최적화 후 실행 시간: " + TimeUnit.NANOSECONDS.toMillis(afterTime) + "ms");
        System.out.println("성능 향상: " + beforeTime / (double)afterTime + "배");
        System.out.println("결과 정확성: " + (result1 == result2));
        System.out.println("교훈: 측정 데이터를 기반으로 핫스팟에 집중해 최적화하라");
    }
}
