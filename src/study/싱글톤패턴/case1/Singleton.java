package study.싱글톤패턴.case1;
/**
 * 가장 기본적인 싱글톤 패턴
 * 단점
 * - 동시성 문제가 발생한다.
 * - static 을 사용하여 전역으로 변수를 관리하여 상속을 하지 못하고 객체의 값을 바꿔줄 수 없기 때문에 테스트하기 어렵다.
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {}

    static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
