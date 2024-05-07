package study.박싱된_기본타입보단_기본타입을_사용;

import java.util.Comparator;

class Case1 {
    public static void main(String[] args) {
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        int compare = naturalOrder.compare(new Integer(42), new Integer(42));
        System.out.println("compare = " + compare);
    }
}
