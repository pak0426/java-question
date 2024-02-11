package study.enum_sample.case1;

public enum FruitEnum {
    Y(1, true),
    N(0, false);

    private int value;
    private boolean flag;

    FruitEnum(int value, boolean flag) {
        this.value = value;
        this.flag = flag;
    }

    public int getValue() {
        return value;
    }

    public boolean isFlag() {
        return flag;
    }
}
