package study.싱글톤패턴.case5;

/**
 * 싱글톤 패턴 동시성 문제 해결 전략
 * 네번째 - inner 클래스 활용
 * inner 클래스를 활용하면 이른 생성이 아닌 getInstance() 메서드를 호출했을때 Inner 클래스에서 인스턴스를 생성해주는 장점이 있다.
 * 동기화 문제도 없고 메모리 낭비도 없다.
 */
class Singleton {
    private Singleton() {}

    public static Singleton getInstance() {
        return SingletonInner.instance;
    }

    static class SingletonInner {
        private static final Singleton instance = new Singleton();
    }
}