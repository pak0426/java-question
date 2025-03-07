package study.effective.item53;

import java.util.ArrayList;
import java.util.List;

/**
 * 이펙티브 자바 아이템 53: "가변인수는 신중히 사용하라"
 */
public class Item53 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 53 예제 =========");
        System.out.println("가변인수는 신중히 사용하라\n");

        // 1. 기본적인 가변인수 사용법
        System.out.println("1. 기본적인 가변인수 사용:");
        int sum = sumVarargs(1, 2, 3, 4, 5);
        System.out.println("  1부터 5까지의 합: " + sum);

        // 인수가 0개인 경우
        int emptySum = sumVarargs();
        System.out.println("  인수가 없는 경우의 합: " + emptySum);

        // 2. 가변인수 메서드의 성능 문제
        System.out.println("\n2. 가변인수 메서드의 성능:");
        System.out.println("  호출할 때마다 배열이 새로 할당되고 초기화됨");

        // 3. 가변인수와 제네릭의 조합
        System.out.println("\n3. 가변인수와 제네릭 조합 (타입 안전 경고):");
        // 아래 메서드는 호출 시 타입 안전 경고가 발생할 수 있음
        List<String> strings = pickFirst("첫번째", "두번째", "세번째");
        System.out.println("  첫 번째 문자열: " + strings.get(0));

        // 4. 최소 1개 이상의 인수가 필요한 경우
        System.out.println("\n4. 최소 1개 이상의 인수가 필요한 경우:");
        int min1 = min(42);
        int min2 = min(8, 23, 5, 3, 42, 15);
        System.out.println("  단일 값의 최솟값: " + min1);
        System.out.println("  여러 값 중 최솟값: " + min2);

        // 아래 코드는 컴파일 에러가 발생함 (인수가 없음)
        // int minError = min();

        // 5. 메서드 오버로딩으로 최적화된 가변인수 사용
        System.out.println("\n5. 메서드 오버로딩으로 최적화된 가변인수 사용:");
        int result1 = optimizedSum(1);
        int result2 = optimizedSum(1, 2);
        int result3 = optimizedSum(1, 2, 3);
        int result4 = optimizedSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("  인수 1개 합: " + result1);
        System.out.println("  인수 2개 합: " + result2);
        System.out.println("  인수 3개 합: " + result3);
        System.out.println("  인수 10개 합: " + result4);
    }

    /**
     * 간단한 가변인수 메서드
     */
    static int sumVarargs(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    /**
     * 가변인수와 제네릭을 함께 사용한 메서드
     * @SafeVarargs 애너테이션은 타입 안전 경고를 억제
     */
    @SafeVarargs
    static <T> List<T> pickFirst(T... elements) {
        List<T> result = new ArrayList<>();
        if (elements.length > 0) {
            result.add(elements[0]);
        }
        return result;
    }

    /**
     * 최소 1개 이상의 인수가 필요한 메서드
     * 첫 번째 인수는 별도로 받고, 나머지를 가변인수로 처리
     */
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    // 아래는 가변인수의 성능을 개선하기 위한 메서드 오버로딩 예시

    /**
     * 인수가 1개인 경우 최적화
     */
    static int optimizedSum(int a) {
        return a;
    }

    /**
     * 인수가 2개인 경우 최적화
     */
    static int optimizedSum(int a, int b) {
        return a + b;
    }

    /**
     * 인수가 3개인 경우 최적화
     */
    static int optimizedSum(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * 인수가 4개 이상인 경우 가변인수 사용
     */
    static int optimizedSum(int a, int b, int c, int d, int... rest) {
        int result = a + b + c + d;
        for (int n : rest) {
            result += n;
        }
        return result;
    }
}
