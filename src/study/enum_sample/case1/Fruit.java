package study.enum_sample.case1;

public class Fruit {
    public String getTable1Value(int originalValue) {
        if (originalValue == 1) {
            return "Y";
        }
        else {
            return "N";
        }
    }

    public boolean getTable2Value(String originalValue) {
        if (originalValue.equals("Y")) {
            return true;
        }
        else {
            return false;
        }
    }
}
