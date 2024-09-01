package study.effective.item13;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 얕은 복사 예제
        ShallowCopy original = new ShallowCopy(1, new int[]{1, 2, 3});
        ShallowCopy cloned = original.clone();

        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        cloned.getArray()[0] = 100;
        System.out.println("After modifying cloned object:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // 깊은 복사 예제
        DeepCopy deepOriginal = new DeepCopy(1, new int[]{1, 2, 3});
        DeepCopy deepCloned = deepOriginal.clone();

        System.out.println("\nDeep Original: " + deepOriginal);
        System.out.println("Deep Cloned: " + deepCloned);

        deepCloned.getArray()[0] = 100;
        System.out.println("After modifying deep cloned object:");
        System.out.println("Deep Original: " + deepOriginal);
        System.out.println("Deep Cloned: " + deepCloned);
    }

    static class ShallowCopy implements Cloneable {
        private int id;
        private int[] array;

        public ShallowCopy(int id, int[] array) {
            this.id = id;
            this.array = array;
        }

        @Override
        public ShallowCopy clone() {
            try {
                return (ShallowCopy) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        public int[] getArray() {
            return array;
        }

        @Override
        public String toString() {
            return "ShallowCopy{id=" + id + ", array=" + Arrays.toString(array) + "}";
        }
    }

    static class DeepCopy implements Cloneable {
        private int id;
        private int[] array;

        public DeepCopy(int id, int[] array) {
            this.id = id;
            this.array = array;
        }

        @Override
        public DeepCopy clone() {
            try {
                DeepCopy cloned = (DeepCopy) super.clone();
                cloned.array = array.clone();
                return cloned;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        public int[] getArray() {
            return array;
        }

        @Override
        public String toString() {
            return "DeepCopy{id=" + id + ", array=" + Arrays.toString(array) + "}";
        }
    }
}
