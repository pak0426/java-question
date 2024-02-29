package study.접근제어자.case2;

import study.접근제어자.case1.Parent2;

public class Child2 {
    public void test() {
        Parent2 parent2 = new Parent2();
        String publicStr = parent2.publicStr;
    }
}
