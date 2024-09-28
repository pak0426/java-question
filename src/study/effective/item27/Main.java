package study.effective.item27;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 비검사 경고가 발생하는 코드
        List<String> strings = new ArrayList();  // 원시 타입 사용으로 인한 경고

        // 경고를 제거한 코드
        List<String> betterStrings = new ArrayList<>();

        // 타입 안전성이 확실한 경우 @SuppressWarnings 사용
        List<String> safeList = createSafeList();

        System.out.println("Better strings: " + betterStrings);
        System.out.println("Safe list: " + safeList);
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> createSafeList() {
        // 이 메서드는 타입 안전성이 보장되므로 경고를 억제합니다.
        List list = new ArrayList();
        return (List<T>) list;  // 타입 캐스팅
    }
}
