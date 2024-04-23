package study.싱글톤패턴.case3;

/**
 * 싱글톤 패턴 동시성 문제 해결 전략
 * 두번째 - synchronized 키워드의 사용
 * 단점
 * synchronized 키워드는 하나의 스레드만 접근하게 있게 해준다.
 * 그에 따라서 스레드 병목 현상 발생할 수 있다.
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {}

    static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}