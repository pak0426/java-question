package study.Setter와Getter.case2;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(80);
    }

    public void studentGrade(Student student) {
        if (student.getScore() > 90) {
            System.out.println("A");
        }
        else if (student.getScore() > 60) {
            System.out.println("B");
        }
        else {
            System.out.println("C");
        }
    }
}
