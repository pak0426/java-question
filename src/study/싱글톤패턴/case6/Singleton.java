package study.싱글톤패턴.case6;
/**
 * 싱글톤 패턴 동시성 문제 해결 전략
 * 다섯번째 - enum 활용
 * enum을 사용하면 JVM 레벨에서 초기화되고 관리되기 때문에 중복 인스턴스 생성이 되지 않는다.
 * 또한 reflection도 방지해준다.
 */
public enum Singleton {
    INSTANCE;
}
