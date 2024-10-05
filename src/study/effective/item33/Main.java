package study.effective.item33;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // 타입 안전 이종 컨테이너 패턴 - API
    public static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T instance) {
            favorites.put(type, type.cast(instance));
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();

        // 타입 안전 이종 컨테이너 사용 예
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

        // 제네릭 타입과 와일드카드 타입을 사용한 더 복잡한 예
        Class<? extends Number> numberType = Integer.class;
        Number number = f.getFavorite(numberType);
        System.out.println("Favorite number: " + number);

        // 런타임 타입 안전성 - ClassCastException 발생 예
        try {
            f.putFavorite((Class)Integer.class, "This will fail");
        } catch (ClassCastException e) {
            System.out.println("Runtime type safety prevented incorrect type: " + e.getMessage());
        }
    }
}