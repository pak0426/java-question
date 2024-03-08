package study.Setter와Getter.case1;

public class Apple {
    private int count;

    public Apple(int count) {
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void sellApple(int sellCount) {
        if (count < sellCount) {
            throw new IllegalArgumentException("남아있는 사과가 부족합니다...");
        }
        count -= sellCount;
    }
}
