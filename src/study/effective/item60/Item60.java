package study.effective.item60;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Item60 {

    public static void main(String[] args) {
        // 1. float/double 부정확성 예시
        demonstrateFloatingPointIssues();

        // 2. BigDecimal 사용 예시
        demonstrateBigDecimal();

        // 3. 정수 타입 사용 예시
        demonstrateIntForMonetary();
    }

    private static void demonstrateFloatingPointIssues() {
        System.out.println("1. float/double의 부정확성 예시:");

        // 금융 계산에서의 부정확성
        double funds = 1.00;
        int itemsBought = 0;

        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }

        System.out.println("구매 항목: " + itemsBought);
        System.out.println("잔돈: " + funds);  // 기대값 0.0이 아님

        // 금융 계산에서의 오류 (비교 연산)
        System.out.println("0.1 + 0.2 == 0.3: " + (0.1 + 0.2 == 0.3));  // false
        System.out.println("0.1 + 0.2: " + (0.1 + 0.2));  // 0.30000000000000004
    }

    private static void demonstrateBigDecimal() {
        System.out.println("\n2. BigDecimal 사용 예시:");

        // 동일한 연산을 BigDecimal로 수행
        BigDecimal funds = new BigDecimal("1.00");
        int itemsBought = 0;

        for (BigDecimal price = new BigDecimal("0.10");
             funds.compareTo(price) >= 0;
             price = price.add(new BigDecimal("0.10"))) {
            funds = funds.subtract(price);
            itemsBought++;
        }

        System.out.println("구매 항목(BigDecimal): " + itemsBought);
        System.out.println("잔돈(BigDecimal): " + funds);

        // 반올림 처리
        BigDecimal value = new BigDecimal("1.25");
        System.out.println("1.25를 소수점 첫째 자리에서 반올림: " +
                value.setScale(0, RoundingMode.HALF_UP));

        // 금융 계산
        BigDecimal principal = new BigDecimal("10000.00");
        BigDecimal rate = new BigDecimal("0.05");  // 5% 이자율
        BigDecimal interest = principal.multiply(rate);
        System.out.println("이자: " + interest);
    }

    private static void demonstrateIntForMonetary() {
        System.out.println("\n3. 정수 타입 사용 예시 (센트 단위):");

        // 달러 대신 센트로 계산 (정수 사용)
        int fundsCents = 100;  // $1.00 -> 100센트
        int itemsBought = 0;

        for (int priceCents = 10; fundsCents >= priceCents; priceCents += 10) {
            fundsCents -= priceCents;
            itemsBought++;
        }

        // 출력 시 포맷팅
        System.out.println("구매 항목(센트): " + itemsBought);
        System.out.println("잔돈(센트): $" + (fundsCents / 100.0));

        // 정수를 사용하여 통화 처리 (내부적으로는 센트 단위 사용)
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        System.out.println("1295센트 = " + df.format(1295 / 100.0));
    }
}
