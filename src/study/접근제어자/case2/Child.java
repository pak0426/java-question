package study.접근제어자.case2;

import study.접근제어자.case1.Parent;

public class Child extends Parent {
    @Override
    public void display() {
        System.out.println("Child Class");
    }
}
