package study.effective.item37;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Plant> garden = Arrays.asList(
                new Plant("Rose", Plant.LifeCycle.PERENNIAL),
                new Plant("Corn", Plant.LifeCycle.ANNUAL),
                new Plant("Oak", Plant.LifeCycle.PERENNIAL),
                new Plant("Bamboo", Plant.LifeCycle.BIENNIAL)
        );

        // 1. ordinal()을 배열 인덱스로 사용 - 따라하지 말 것!
        System.out.println("Using ordinal indexing (Not recommended):");
        useOrdinalIndexing(garden);

        System.out.println("\n2. EnumMap 사용 (권장):");
        useEnumMap(garden);
    }

    // Plant 클래스 정의
    static class Plant {
        enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

        final String name;
        final LifeCycle lifeCycle;

        Plant(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // ordinal()을 배열 인덱스로 사용 - 좋지 않은 방식
    static void useOrdinalIndexing(List<Plant> garden) {
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    // EnumMap 사용 - 권장되는 방식
    static void useEnumMap(List<Plant> garden) {
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycle);
    }
}