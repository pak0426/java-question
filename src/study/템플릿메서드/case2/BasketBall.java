package study.템플릿메서드.case2;

class BasketBall extends Sports {
    @Override
    public void shoot() {
        System.out.println("손으로 패스하다!");
    }

    @Override
    public void pass() {
        System.out.println("발로 패스하다!");
    }
}
