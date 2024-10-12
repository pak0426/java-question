package study.effective.item40;

public class Main {
    public static void main(String[] args) {
        Bigram bigram1 = new Bigram('H', 'i');
        Bigram bigram2 = new Bigram('H', 'i');

        System.out.println("bigram1.equals(bigram2): " + bigram1.equals(bigram2));
        System.out.println("bigram1.hashCode(): " + bigram1.hashCode());
        System.out.println("bigram2.hashCode(): " + bigram2.hashCode());

        BigramWithOverride bigramOverride1 = new BigramWithOverride('H', 'i');
        BigramWithOverride bigramOverride2 = new BigramWithOverride('H', 'i');

        System.out.println("bigramOverride1.equals(bigramOverride2): " + bigramOverride1.equals(bigramOverride2));
        System.out.println("bigramOverride1.hashCode(): " + bigramOverride1.hashCode());
        System.out.println("bigramOverride2.hashCode(): " + bigramOverride2.hashCode());
    }
}

class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }
}

class BigramWithOverride {
    private final char first;
    private final char second;

    public BigramWithOverride(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BigramWithOverride))
            return false;
        BigramWithOverride b = (BigramWithOverride) o;
        return b.first == first && b.second == second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }
}
