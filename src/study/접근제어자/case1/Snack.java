package study.접근제어자.case1;

public class Snack {
    private String name;
    public int price;

    protected String company;

    public Snack(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Snack(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }
}
