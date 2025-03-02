package study.effective.item48;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 이펙티브 자바 아이템 48: "스트림 병렬화는 주의해서 적용하라"
 *
 * 1. 스트림 병렬화가 항상 성능을 향상시키지는 않는다
 * 2. 병렬화에 적합한 스트림 소스와 연산
 * 3. 병렬화를 올바르게 사용하는 방법
 * 4. 잘못된 병렬화 사용 시 성능 저하 및 예상치 못한 결과가 발생할 수 있음
 */
public class Item48 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 48 예제 =========");
        System.out.println("스트림 병렬화는 주의해서 적용하라\n");

        // 1. 메르센 소수 계산 - 병렬화에 적합하지 않은 예
        System.out.println("1. 메르센 소수 찾기 (병렬화에 부적합한 예)");
        long start = System.currentTimeMillis();
        mersennePrimes(10);
        long end = System.currentTimeMillis();
        System.out.println("  순차 스트림 실행 시간: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        mersennePrimesParallel(10);
        end = System.currentTimeMillis();
        System.out.println("  병렬 스트림 실행 시간: " + (end - start) + "ms");
        System.out.println("  (주의: 병렬 처리가 항상 빠른 것은 아닙니다)\n");

        // 2. 소수 숫자 합산 - 병렬화에 적합한 예
        System.out.println("2. 소수 합산 (병렬화에 적합한 예)");
        long n = 10_000_000;

        start = System.currentTimeMillis();
        long sum = sumOfPrimes(n);
        end = System.currentTimeMillis();
        System.out.println("  순차 처리 합계: " + sum);
        System.out.println("  순차 스트림 실행 시간: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        sum = parallelSumOfPrimes(n);
        end = System.currentTimeMillis();
        System.out.println("  병렬 처리 합계: " + sum);
        System.out.println("  병렬 스트림 실행 시간: " + (end - start) + "ms\n");

        // 3. 병렬화에 적합한 소스와 부적합한 소스
        System.out.println("3. 다양한 소스의 병렬화 특성");

        // ArrayList - 병렬화에 적합 (분할이 용이)
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }

        System.out.println("  ArrayList 스트림 병렬 처리 (분할이 용이):");
        System.out.println("    " + arrayList.parallelStream().limit(10).collect(Collectors.toList()));

        // 난수 스트림 - 병렬화에 부적합 (상태 의존성)
        System.out.println("  난수 생성 스트림 병렬 처리 (상태 의존성):");
        System.out.println("    실행마다 결과가 달라질 수 있음");
        System.out.println("    " + Stream.generate(ThreadLocalRandom.current()::nextInt)
                .parallel().limit(10).collect(Collectors.toList()));

        // 4. 병렬화에 적합한 종단 연산 예시
        System.out.println("\n4. 병렬화에 적합한 종단 연산과 부적합한 종단 연산");
        System.out.println("  적합한 종단 연산: reduce, min, max, count, sum, anyMatch, allMatch");
        System.out.println("  부적합한 종단 연산: collect(특히 groupingBy, joining 등)");

        // reduce 연산 예시 - 병렬화에 적합
        long reduceResult = LongStream.rangeClosed(1, 10)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println("  병렬 reduce 연산 결과: " + reduceResult);

        // 5. 병렬화가 유용한 경우와 그렇지 않은 경우
        System.out.println("\n5. 병렬화 사용 지침");
        System.out.println("  - 소스가 ArrayList, HashMap, HashSet, ConcurrentHashMap, 배열, int 범위, long 범위일 때 적합");
        System.out.println("  - 종단 연산이 reduction(축소)인 경우 적합 (min, max, sum, count)");
        System.out.println("  - 요소들이 독립적으로 처리될 수 있어야 함");
        System.out.println("  - 요소 수 * 요소당 처리 시간이 충분히 클 때 성능 향상을 기대할 수 있음");
    }

    /**
     * 메르센 소수 계산 (순차 처리)
     * 메르센 소수: 2^p - 1 형태의 소수 (p도 소수)
     */
    private static List<BigInteger> mersennePrimes(int n) {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime)
                .map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(n)
                .collect(Collectors.toList());
    }

    /**
     * 메르센 소수 계산 (병렬 처리) - 부적합한 예시
     * 병렬화가 성능 저하를 일으킬 수 있음
     */
    private static List<BigInteger> mersennePrimesParallel(int n) {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime)
                .parallel() // 병렬 스트림으로 변환 - 성능 저하 가능성 있음
                .map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(n)
                .collect(Collectors.toList());
    }

    /**
     * n까지의 소수 합계 (순차 처리)
     * 범위 기반 스트림 - 분할이 용이하여 병렬화에 적합
     */
    private static long sumOfPrimes(long n) {
        return LongStream.rangeClosed(2, n)
                .filter(Item48::isPrime)
                .sum();
    }

    /**
     * n까지의 소수 합계 (병렬 처리)
     * LongStream.rangeClosed는 분할이 용이하므로 병렬화에 적합
     */
    private static long parallelSumOfPrimes(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel() // 병렬 스트림으로 변환
                .filter(Item48::isPrime)
                .sum();
    }

    /**
     * 소수 판별 메서드
     */
    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
