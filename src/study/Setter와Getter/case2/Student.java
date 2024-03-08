package study.Setter와Getter.case2;

public class Student {
    private int score;

    private int presentationScore;
    private int homeworkScore;

    public void studentGrade() {
        int totalScore = presentationScore + homeworkScore;

        if (totalScore > 90) {
            System.out.println("A");
        }
        else if (totalScore > 60) {
            System.out.println("B");
        }
        else {
            System.out.println("C");
        }
    }

    public Student(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
