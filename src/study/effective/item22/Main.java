package study.effective.item22;

public class Main {
    public static void main(String[] args) {
        // 잘못된 사용: 상수 인터페이스
        System.out.println("잘못된 상수 인터페이스 사용:");
        System.out.println("개 소리: " + AnimalSoundsConstant.DOG_SOUND);

        // 올바른 사용: 유틸리티 클래스
        System.out.println("\n올바른 유틸리티 클래스 사용:");
        System.out.println("고양이 소리: " + AnimalSounds.CAT_SOUND);

        // 올바른 사용: 열거 타입
        System.out.println("\n올바른 열거 타입 사용:");
        System.out.println("닭 소리: " + Animal.CHICKEN.getSound());
    }
}

// 안티패턴: 상수 인터페이스
interface AnimalSoundsConstant {
    String DOG_SOUND = "멍멍";
    String CAT_SOUND = "야옹";
    String CHICKEN_SOUND = "꼬끼오";
}

// 올바른 방법: 유틸리티 클래스
final class AnimalSounds {
    private AnimalSounds() {} // 인스턴스화 방지

    public static final String DOG_SOUND = "멍멍";
    public static final String CAT_SOUND = "야옹";
    public static final String CHICKEN_SOUND = "꼬끼오";
}

// 올바른 방법: 열거 타입
enum Animal {
    DOG("멍멍"),
    CAT("야옹"),
    CHICKEN("꼬끼오");

    private final String sound;

    Animal(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }
}
