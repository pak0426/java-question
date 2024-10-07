package study.effective.item35;

public class Main {
    public static void main(String[] args) {
        // ordinal()을 잘못 사용한 예
        for (WrongEnsemble ensemble : WrongEnsemble.values()) {
            System.out.println(ensemble + " has " + ensemble.numberOfMusicians() + " musicians");
        }

        System.out.println();

        // 인스턴스 필드를 올바르게 사용한 예
        for (Ensemble ensemble : Ensemble.values()) {
            System.out.println(ensemble + " has " + ensemble.getNumberOfMusicians() + " musicians");
        }
    }
}

// ordinal()을 잘못 사용한 열거 타입 - 따라하지 말 것!
enum WrongEnsemble {
    SOLO, DUET, TRIO, QUARTET, QUINTET;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}

// 인스턴스 필드를 사용한 열거 타입 - 이 방식을 따를 것!
enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int getNumberOfMusicians() {
        return numberOfMusicians;
    }
}
