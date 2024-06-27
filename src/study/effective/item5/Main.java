package study.effective.item5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 의존 객체들을 생성
        Dictionary englishDictionary = new EnglishDictionary();
        Dictionary spanishDictionary = new SpanishDictionary();

        // 의존 객체 주입을 사용하여 SpellChecker 인스턴스들을 생성
        SpellChecker englishChecker = new SpellChecker(englishDictionary);
        SpellChecker spanishChecker = new SpellChecker(spanishDictionary);

        // 영어 철자 검사
        System.out.println("English spell check:");
        System.out.println("'hello' is correct: " + englishChecker.isValid("hello"));
        System.out.println("'helo' is correct: " + englishChecker.isValid("helo"));

        // 스페인어 철자 검사
        System.out.println("\nSpanish spell check:");
        System.out.println("'hola' is correct: " + spanishChecker.isValid("hola"));
        System.out.println("'ola' is correct: " + spanishChecker.isValid("ola"));
    }
}

// 사전 인터페이스
interface Dictionary {
    boolean contains(String word);
}

// 영어 사전 구현
class EnglishDictionary implements Dictionary {
    private List<String> words = new ArrayList<>();

    EnglishDictionary() {
        words.add("hello");
        words.add("world");
        // 더 많은 단어들...
    }

    @Override
    public boolean contains(String word) {
        return words.contains(word.toLowerCase());
    }
}

// 스페인어 사전 구현
class SpanishDictionary implements Dictionary {
    private List<String> words = new ArrayList<>();

    SpanishDictionary() {
        words.add("hola");
        words.add("mundo");
        // 더 많은 단어들...
    }

    @Override
    public boolean contains(String word) {
        return words.contains(word.toLowerCase());
    }
}

// 철자 검사기
class SpellChecker {
    private final Dictionary dictionary;

    // 의존 객체 주입
    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }
}
