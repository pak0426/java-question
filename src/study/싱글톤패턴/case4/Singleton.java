package study.싱글톤패턴.case4;

/**
 * 싱글톤 패턴 동시성 문제 해결 전략
 * 세번째 - volatile 키워드 사용
 * 단점
 * volatile은 CPU 메모리에 캐싱된 값을 가져오는 것이 아닌 메모리 영역에서 직접 값을 가져온다.
 * 즉 멀티 스레드들의 값을 동기화 시켜준다.
 */
class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}