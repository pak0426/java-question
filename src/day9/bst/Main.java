package day9.bst;

public class Main {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        long startTime = System.nanoTime();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("이진트리 측정");
        long endTime = System.nanoTime();
        System.out.println("삽입 소요시간: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        tree.delete(20);
        endTime = System.nanoTime();
        System.out.println("삭제 소요시간: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        tree.insertAt(tree.getRoot(), 20, 1);
        endTime = System.nanoTime();
        System.out.println("중간 삽입 소요시간: " + (endTime - startTime) + "ns");
    }
}
