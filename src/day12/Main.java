package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * 공변성은 서로 다른 타입간에 함께 변할 수 있는 특징을 말한다. 이는 객체지향 원칙 중 리스코프 치환 원칙에 해당 한다.
         */

        // 공변성
        Object[] a = new Integer[10];

        // 불공변성
        Integer[] b = (Integer[]) a;

        /**
         * 아래 코드는 컴파일 시점에 에러가 난다.
         * 배열과 달리 제네릭 타입에서는 공변과 불공변성을 지원하지 않기 때문이다.
         */

        // 공변성
//        List<Object> aa = new ArrayList<Integer>();

        // 불공변성
//        List<Integer> bb = new ArrayList<Object>();

        // 다형성 (업캐스팅)
        Object parent = new Object();
        Integer child = Integer.parseInt("1");

        parent = child;

        // 다형성 (다운캐스팅)
        Object parent2 = new Object();
        Integer child2 = Integer.parseInt("2");

        child = (Integer) parent2;

        // 컬렉션 프레임 워크 상속
        Collection<Integer> p = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        // 업 캐스팅 불가능
        p = c;

        // 다운 캐스팅 불가능
//        c = p;

        /**
         * 제네릭 와일드 카드
         * <?> 비한정적 와일드 카드, 제한없음 (모든 타입 가능)
         * <? extends U> 상한 경계 와일드 카드, 상위 클래스 제한 (U와 그 자손들만 가능), 상한이 U라 상한 경계라고 한다.
         * <? super U> 하한 경계 와일드 카드, 하위 클래스 제한 (U와 그 조상들만 가능), 하한이 U라 하한 경계라고 한다.
         */

        ArrayList<? extends Object> parent3 = new ArrayList<>();
        ArrayList<? extends Integer> child3 = new ArrayList<>();
        parent3 = child3; // 공변성 (제네릭 업캐스팅)

        ArrayList<? super Object> parent4 = new ArrayList<>();
        ArrayList<? super Integer> child4 = new ArrayList<>();
        child4 = parent4; // 불공변성 (제네릭 다운 캐스팅)
    }
}
