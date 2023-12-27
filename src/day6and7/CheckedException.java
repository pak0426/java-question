package day6and7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedException {
    public static void main(String args[]) {
        try {
            File file = new File("test.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                System.out.println("line = " + line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("e.getMessage() : " + e.getMessage());
        }
    }
}
