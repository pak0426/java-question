package study.effective.item8;

public class Main {
    public static void main(String[] args) {
        // 잘못된 방법: finalize에 의존
        BadResource badResource = new BadResource();
        badResource.use();
        // 여기서 명시적으로 정리하지 않음

        // 올바른 방법: try-with-resources 사용
        try (GoodResource goodResource = new GoodResource()) {
            goodResource.use();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // finalize를 사용하는 잘못된 예
    static class BadResource {ddd
        public void use() {
            System.out.println("BadResource 사용 중");
        }

        @Override
        protected void finalize() {
            System.out.println("BadResource finalize 호출됨 (신뢰할 수 없음)");
        }
    }

    // AutoCloseable을 구현하는 올바른 예
    static class GoodResource implements AutoCloseable {
        public void use() {
            System.out.println("GoodResource 사용 중");
        }

        @Override
        public void close() {
            System.out.println("GoodResource 명시적으로 닫힘");
        }
    }
}
