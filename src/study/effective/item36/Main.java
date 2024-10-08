package study.effective.item36;

import java.util.EnumSet;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        // 비트 필드 사용 예제
        int oldStyle = TextStyle.BOLD | TextStyle.ITALIC;
        System.out.println("Old style (bit field): " + oldStyle);
        printTextStyleOld(oldStyle);

        System.out.println();

        // EnumSet 사용 예제
        EnumSet<TextAttribute> newStyle = EnumSet.of(TextAttribute.BOLD, TextAttribute.ITALIC);
        System.out.println("New style (EnumSet): " + newStyle);
        printTextStyleNew(newStyle);
    }

    // 비트 필드를 사용한 정수형 상수 - 따라하지 말 것!
    public interface TextStyle {
        int BOLD = 1 << 0; // 1
        int ITALIC = 1 << 1; // 2
        int UNDERLINE = 1 << 2; // 4
        int STRIKETHROUGH = 1 << 3; // 8
    }

    // 비트 필드를 사용한 메서드
    public static void printTextStyleOld(int styles) {
        System.out.print("Text is ");
        if ((styles & TextStyle.BOLD) != 0) System.out.print("bold ");
        if ((styles & TextStyle.ITALIC) != 0) System.out.print("italic ");
        if ((styles & TextStyle.UNDERLINE) != 0) System.out.print("underlined ");
        if ((styles & TextStyle.STRIKETHROUGH) != 0) System.out.print("strikethrough ");
        System.out.println();
    }

    // EnumSet을 사용한 열거 타입
    public enum TextAttribute {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    // EnumSet을 사용한 메서드
    public static void printTextStyleNew(EnumSet<TextAttribute> styles) {
        System.out.print("Text is ");
        if (styles.contains(TextAttribute.BOLD)) System.out.print("bold ");
        if (styles.contains(TextAttribute.ITALIC)) System.out.print("italic ");
        if (styles.contains(TextAttribute.UNDERLINE)) System.out.print("underlined ");
        if (styles.contains(TextAttribute.STRIKETHROUGH)) System.out.print("strikethrough ");
        System.out.println();
    }
}
