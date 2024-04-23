package study.싱글톤패턴.case2;

/**
 * 싱글톤 패턴 동시성 문제 해결 전략
 * 첫번째 - 이른 로딩
 * 단점
 * 객체가 생성하지 않은 시점에 미리 객체를 생성하기 때문에 불필요한 메모리를 낭비하게 된다.
 */
class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    static Singleton getInstance() {
        return instance;
    }
}
