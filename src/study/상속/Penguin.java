package study.상속;

public class Penguin extends Animals {
    public String habitat;

    public void showHabitat() {
        System.out.println("내가 사는 곳은 " + habitat);
    }

    @Override
    public void move() {
        System.out.println("펭귄은 뒤뚱뒤뚱 움직인다.");
    }
}
