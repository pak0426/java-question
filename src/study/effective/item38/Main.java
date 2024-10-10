package study.effective.item38;

public class Main {
    public static void main(String[] args) {
        System.out.println("Basic operation examples:");
        testOperation(BasicOperation.PLUS, 10, 5);
        testOperation(BasicOperation.MINUS, 10, 5);

        System.out.println("\nExtended operation examples:");
        testOperation(ExtendedOperation.EXP, 2, 3);
        testOperation(ExtendedOperation.REMAINDER, 10, 3);
    }

    private static void testOperation(Operation op, double x, double y) {
        System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}

interface Operation {
    double apply(double x, double y);
}

enum BasicOperation implements Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) { return Math.pow(x, y); }
    },
    REMAINDER("%") {
        public double apply(double x, double y) { return x % y; }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
