package study.Setter와Getter.case1;


public class AppleService {
    public void sellApple(int sellCount) {
        Apple apple = new Apple(1000);
        int nowCount = apple.getCount() - sellCount;

        if (nowCount < 0) {
            throw new IllegalArgumentException("남아있는 사과가 부족합니다...");
        }

        apple.setCount(nowCount);
    }
}
