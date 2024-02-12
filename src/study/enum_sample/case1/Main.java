package study.enum_sample.case1;

public class Main {
    public static void main(String args[]) {
        ValueEnum valueEnumY = ValueEnum.Y;
        ValueEnum valueEnumN = ValueEnum.N;

        System.out.println("fruitEnumY = " + valueEnumY.getTable1Value() + " " + valueEnumY.isTable2Value());
        System.out.println("fruitEnumN = " + valueEnumN.getTable1Value() + " " + valueEnumN.isTable2Value());
    }
}