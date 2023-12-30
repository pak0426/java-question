package day10;

import java.util.Objects;

public class Key {
    String key;

    Key(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Key key1 = (Key) obj;
        return Objects.equals(key, key1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
