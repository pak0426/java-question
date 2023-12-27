package day6and7;

public class UncheckedException2 {
     public static void main(String args[]) {
         int numbers[] = {0, 1, 2, 3, 4};
         int index = 10;

         try {
            System.out.println(numbers[index]);
         }
         catch (ArrayIndexOutOfBoundsException e) {
             System.out.println("e.getMessage(): " + e.getMessage());
         }
     }
}
