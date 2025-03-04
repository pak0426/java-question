package study.effective.item50;

import java.util.Date;
import java.time.Instant;

/**
 * 이펙티브 자바 아이템 50: "적시에 방어적 복사본을 만들라"
 */
public class Item50 {

    public static void main(String[] args) {
        System.out.println("========= 이펙티브 자바 아이템 50 예제 =========");
        System.out.println("적시에 방어적 복사본을 만들라\n");

        // 1. 방어적 복사를 하지 않은 객체의 문제점
        System.out.println("1. 방어적 복사 없는 객체의 취약점:");
        Date start = new Date();
        Date end = new Date();
        end.setTime(start.getTime() + 1000 * 60 * 60); // 1시간 후

        // 취약한 기간 클래스 사용
        VulnerablePeriod vp = new VulnerablePeriod(start, end);
        System.out.println("  원본 기간: " + vp);

        // 외부에서 내부 객체 수정 가능 - 불변식 파괴!
        end.setTime(start.getTime() - 10); // 시작 시간보다 종료 시간이 빠르게 설정
        System.out.println("  공격 후 기간: " + vp);

        // 2. 방어적 복사로 개선된 객체
        System.out.println("\n2. 방어적 복사로 보호된 객체:");
        start = new Date();
        end = new Date();
        end.setTime(start.getTime() + 1000 * 60 * 60); // 1시간 후

        // 안전한 기간 클래스 사용
        Period p = new Period(start, end);
        System.out.println("  원본 기간: " + p);

        // 외부에서 원본 객체를 수정해도 내부 객체에 영향 없음
        end.setTime(start.getTime() - 10);
        System.out.println("  외부 객체 수정 후 기간 (영향 없음): " + p);

        try {
            // 생성자에서 유효성 검사로 잘못된 값 차단
            new Period(new Date(), new Date(0)); // 종료 시간이 시작 시간보다 이전
        } catch (IllegalArgumentException e) {
            System.out.println("\n  예상된 예외 발생: " + e.getMessage());
        }

        // 3. getter에서도 방어적 복사 필요
        System.out.println("\n3. getter에서의 방어적 복사:");
        start = new Date();
        end = new Date();
        end.setTime(start.getTime() + 1000 * 60 * 60); // 1시간 후

        Period p2 = new Period(start, end);
        System.out.println("  원본 기간: " + p2);

        // getter로 가져온 객체를 수정 시도
        Date mutableEnd = p2.getEnd();
        mutableEnd.setTime(p2.getStart().getTime() - 10); // 수정 시도
        System.out.println("  getter 반환 객체 수정 후에도 내부 객체 보호됨: " + p2);
    }

    /**
     * 취약한 기간 클래스 - 방어적 복사 없음
     */
    static class VulnerablePeriod {
        private final Date start;
        private final Date end;

        // 방어적 복사 없는 생성자 - 취약점!
        public VulnerablePeriod(Date start, Date end) {
            if (start.compareTo(end) > 0) {
                throw new IllegalArgumentException("시작 시간이 종료 시간보다 늦을 수 없습니다.");
            }
            this.start = start;
            this.end = end;
        }

        public Date getStart() {
            return start;
        }

        public Date getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "시작: " + start + ", 종료: " + end;
        }
    }

    /**
     * 안전한 기간 클래스 - 방어적 복사 사용
     */
    static class Period {
        private final Date start;
        private final Date end;

        // 방어적 복사를 사용한 생성자
        public Period(Date start, Date end) {
            // 인수의 방어적 복사본 생성
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());

            // 복사본으로 유효성 검사 수행
            if (this.start.compareTo(this.end) > 0) {
                throw new IllegalArgumentException("시작 시간이 종료 시간보다 늦을 수 없습니다.");
            }
        }

        // 방어적 복사본을 반환하는 접근자
        public Date getStart() {
            return new Date(start.getTime());
        }

        public Date getEnd() {
            return new Date(end.getTime());
        }

        @Override
        public String toString() {
            return "시작: " + start + ", 종료: " + end;
        }
    }

    /**
     * 참고: Java 8 이후에는 불변 객체인 Instant 사용을 권장
     */
    static class ModernPeriod {
        private final Instant start;
        private final Instant end;

        public ModernPeriod(Instant start, Instant end) {
            // Instant는 불변이므로 방어적 복사가 필요 없음
            this.start = start;
            this.end = end;

            if (this.start.isAfter(this.end)) {
                throw new IllegalArgumentException("시작 시간이 종료 시간보다 늦을 수 없습니다.");
            }
        }

        public Instant getStart() {
            return start;
        }

        public Instant getEnd() {
            return end;
        }
    }
}
