package study.effective.item39;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = SampleTest.class;
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
}

class SampleTest {
    @Test
    public static void m1() { }  // Should pass

    public static void m2() { }  // Should be ignored

    @Test
    public static void m3() {    // Should fail
        throw new RuntimeException("Boom");
    }

    @Test
    public void m4() { }  // Should fail (not static)
}
