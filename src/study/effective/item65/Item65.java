package study.effective.item65;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Set;

public class Item65 {
    public static void main(String[] args) {
        // 1. 리플렉션 사용 예시 (단점 발생)
        try {
            // 클래스 이름을 문자열로 받아 객체 생성 (런타임에 결정)
            String className = "java.util.HashSet";

            // 리플렉션으로 객체 생성
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object reflectionInstance = constructor.newInstance();

            System.out.println("리플렉션으로 생성된 객체: " + reflectionInstance.getClass().getName());

            // 리플렉션의 단점
            // 1. 컴파일타임 타입 검사 혜택 사라짐
            // 2. 코드가 장황해짐
            // 3. 성능이 저하됨
            // 4. 런타임 오류 발생 가능성 높음

            // 리플렉션으로 메서드 호출시 발생하는 문제 (형변환 필요, 런타임 오류 가능)
            @SuppressWarnings("unchecked")
            Set<String> s = (Set<String>) reflectionInstance;
            s.add("리플렉션 사용");
            System.out.println(s);

        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        // 2. 권장 방식: 리플렉션은 인스턴스 생성에만 사용하고, 이후엔 인터페이스로 참조
        String[] classNames = {"java.util.HashSet", "java.util.TreeSet"};

        for (String className : classNames) {
            try {
                // 리플렉션은 객체 생성에만 제한적으로 사용
                @SuppressWarnings("unchecked")
                Class<? extends Set<String>> clazz =
                        (Class<? extends Set<String>>) Class.forName(className);

                // 인터페이스 타입으로 참조 (Set)
                Set<String> set = clazz.getDeclaredConstructor().newInstance();

                // 이후 작업은 인터페이스 타입으로 수행 (리플렉션 사용 안함)
                set.addAll(Arrays.asList("인터페이스", "사용", "권장"));
                System.out.println(className + " 구현체 생성 후 인터페이스로 사용: " + set);

            } catch (ReflectiveOperationException e) {
                System.out.println("리플렉션 오류: " + e);
            }
        }

        // 3. 실무적 상황 - 서비스 로더 패턴 (리플렉션 대안)
        ServiceLoader serviceLoader = new ServiceLoader();
        Set<String> serviceImpl = serviceLoader.loadService("HASH_SET");
        serviceImpl.add("서비스 로더 패턴");
        System.out.println("서비스 로더 패턴으로 생성된 객체: " + serviceImpl);
    }

    // 서비스 로더 패턴의 간략한 구현 (리플렉션 대안)
    static class ServiceLoader {
        public Set<String> loadService(String serviceType) {
            // 실제로는 ServiceLoader API를 사용하거나 DI 프레임워크를 활용함
            // 여기서는 간단한 팩토리 패턴으로 대체
            if ("HASH_SET".equals(serviceType)) {
                return new java.util.HashSet<>();
            } else if ("TREE_SET".equals(serviceType)) {
                return new java.util.TreeSet<>();
            }
            return new java.util.HashSet<>(); // 기본값
        }
    }
}
