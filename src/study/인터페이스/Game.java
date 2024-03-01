package study.인터페이스;

public interface Game {
    public void move();

    public void attack();

    default void protect() {
        System.out.println("방어");
    };

    default void heal() {
        System.out.println("회복");
    }
}
