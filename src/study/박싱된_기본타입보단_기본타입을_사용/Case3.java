package study.박싱된_기본타입보단_기본타입을_사용;

class Case3 {
    public static void main(String[] args) {
        boxingTest();
        unboxingTest();
    }

    public static void boxingTest() {
        Long sum = 0L;

        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("박싱 타입 소요시간: " + (end - start));
    }

    public static void unboxingTest() {
        long sum = 0L;

        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("언방식 타입 소요시간: " + (end - start));
    }
}
