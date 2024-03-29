package study.템플릿메서드.case2;

class Soccer extends Sports {

    @Override
    public void shoot() {
        System.out.println("발로 슈팅하다!");
    }

    @Override
    public void pass() {
        System.out.println("발로 패스하다!");
    }
}
