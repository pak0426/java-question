package study.effective.item47;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

/**
 * 이펙티브 자바 아이템 47: "반환 타입으로는 스트림보다 컬렉션이 낫다"
 *
 * 1. API 설계 시 스트림보다 컬렉션이 더 좋은 반환 타입인 이유
 * 2. Collection 인터페이스가 Iterable을 확장하고 stream 메서드도 제공하기 때문에
 *    Stream과 Iterable을 모두 사용하는 클라이언트를 지원할 수 있음
 * 3. 스트림을 반환하는 API와 반복자를 위한 API를 함께 제공하는 방법
 */
public class Item47 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 47 예제 =========");
        System.out.println("반환 타입으로는 스트림보다 컬렉션이 낫다\n");

        // PowerSet 예제
        Set<String> set = Set.of("a", "b", "c");
        System.out.println("원본 집합: " + set);

        // 멱집합(PowerSet) 구하기
        Collection<Set<String>> powerSet = PowerSet.of(set);
        System.out.println("멱집합 크기: " + powerSet.size());
        System.out.println("멱집합 내용: " + powerSet);

        // 컬렉션이 반환될 경우 - 스트림과 반복문 모두 사용 가능
        System.out.println("\n컬렉션 반환 - 다양한 사용 방법:");

        // 1. for-each 루프 사용 (Iterable로 사용)
        System.out.println("\n1. for-each 루프 사용:");
        for (Set<String> subset : powerSet) {
            System.out.println("  " + subset);
        }

        // 2. 스트림 사용
        System.out.println("\n2. 스트림 API 사용:");
        powerSet.stream()
                .filter(s -> s.size() > 1)
                .map(s -> String.join(", ", s))
                .forEach(s -> System.out.println("  {" + s + "}"));

        // 스트림을 반환하는 API 예제
        System.out.println("\n스트림만 반환하는 API 사용:");
        Stream<Set<String>> powerSetStream = PowerSet.streamOf(set);
        powerSetStream.limit(4).forEach(s -> System.out.println("  " + s));

        // 스트림만 반환할 경우 반복문에서 사용하려면 어댑터 필요
        System.out.println("\n스트림을 반복문에서 사용하려면 변환 필요:");
        try {
            // 다음 코드는 컴파일 에러 발생 (주석 해제 시)
            // for (Set<String> subset : PowerSet.streamOf(set)) { }

            // 스트림을 Iterable로 변환하는 어댑터 사용
            for (Set<String> subset : iterableOf(PowerSet.streamOf(set))) {
                System.out.println("  " + subset);
                if (subset.size() >= 2) break; // 예제 출력 제한
            }
        } catch (Exception e) {
            System.out.println("  오류: " + e.getMessage());
        }

        // 반복자(Iterable)를 스트림으로 변환하는 예제
        System.out.println("\n반복자(Iterable)를 스트림으로 변환:");
        // PowerSet.iterator 메서드를 사용하여 Iterator 생성
        Iterator<Set<String>> iterator = PowerSet.iterator(set);
        // Iterator를 Iterable로 변환
        Iterable<Set<String>> powerSetIterable = () -> iterator;
        // Iterable을 스트림으로 변환
        streamOf(powerSetIterable)
                .limit(4)
                .forEach(s -> System.out.println("  " + s));
    }

    /**
     * 스트림을 Iterable로 변환하는 어댑터 메서드
     */
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    /**
     * Iterable을 스트림으로 변환하는 어댑터 메서드
     */
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    /**
     * 멱집합(PowerSet) 구현 클래스
     * 멱집합: 어떤 집합의 모든 부분집합들로 구성된 집합
     */
    private static class PowerSet {
        /**
         * 주어진 집합의 모든 부분집합을 Collection으로 반환
         * Collection은 Iterable을 확장하면서 stream()도 제공하므로 양쪽 모두 지원
         */
        public static <E> Collection<Set<E>> of(Set<E> s) {
            List<E> src = new ArrayList<>(s);
            int size = s.size();
            int numSubsets = 1 << size; // 2^n 개의 부분집합 생성

            Collection<Set<E>> result = new ArrayList<>(numSubsets);

            for (int i = 0; i < numSubsets; i++) {
                Set<E> subset = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset.add(src.get(j));
                    }
                }
                result.add(subset);
            }

            return result;
        }

        /**
         * 스트림만 반환하는 API 예시
         * 사용은 제한적이지만 무한 스트림도 반환 가능
         */
        public static <E> Stream<Set<E>> streamOf(Set<E> s) {
            List<E> src = new ArrayList<>(s);
            int size = s.size();
            int numSubsets = 1 << size;

            return Stream.iterate(0, n -> n < numSubsets, n -> n + 1)
                    .map(i -> {
                        Set<E> subset = new HashSet<>();
                        for (int j = 0; j < size; j++) {
                            if ((i & (1 << j)) != 0) {
                                subset.add(src.get(j));
                            }
                        }
                        return subset;
                    });
        }

        /**
         * 반복자(Iterator)를 직접 반환하는 메서드
         * 잘 설계된 API라면 이런 메서드 대신 Collection을 반환하는 것이 좋음
         */
        public static <E> Iterator<Set<E>> iterator(Set<E> s) {
            List<E> src = new ArrayList<>(s);
            int size = s.size();
            int numSubsets = 1 << size;

            return new Iterator<Set<E>>() {
                private int i = 0;

                @Override
                public boolean hasNext() {
                    return i < numSubsets;
                }

                @Override
                public Set<E> next() {
                    if (!hasNext())
                        throw new NoSuchElementException();

                    Set<E> subset = new HashSet<>();
                    for (int j = 0; j < size; j++) {
                        if ((i & (1 << j)) != 0) {
                            subset.add(src.get(j));
                        }
                    }
                    i++;
                    return subset;
                }
            };
        }
    }
}
