package study.접근제어자.case2;

import study.접근제어자.case1.Parent;
import study.접근제어자.case1.Parent2;

public class Child3 extends Parent2 {
    public void test() {
        Parent2 parent2 = new Parent2();
        parentMethod();

        Parent parent = new Parent();
    }
}
