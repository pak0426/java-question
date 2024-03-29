package study.템플릿메서드.case2;

abstract class Sports {
    public void run() {
        System.out.println("달리다!");
    }

    public void defense() {
        System.out.println("수비하다!");
    }

    public abstract void shoot();

    public abstract void pass();
}
