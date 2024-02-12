package study.enum_sample.case1;

public enum ValueEnum {
    Y(1, true),
    N(0, false);

    private int table1Value;
    private boolean table2Value;

    ValueEnum(int value, boolean flag) {
        this.table1Value = value;
        this.table2Value = flag;
    }

    public int getTable1Value() {
        return table1Value;
    }

    public boolean isTable2Value() {
        return table2Value;
    }
}
