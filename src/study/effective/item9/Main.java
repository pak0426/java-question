package study.effective.item9;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // try-finally 방식 (권장하지 않음)
        oldWayWithTryFinally();

        // try-with-resources 방식 (권장)
        newWayWithTryWithResources();
        multipleResourcesWithTryWithResources();
    }

    // try-finally 방식
    private static void oldWayWithTryFinally() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/hmmini/Downloads/IMG_5233.jpg"));
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // try-with-resources 방식
    private static void newWayWithTryWithResources() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/hmmini/Downloads/IMG_5233.jpg"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 여러 리소스를 사용하는 경우
    private static void multipleResourcesWithTryWithResources() {
        try (InputStream in = new FileInputStream("/Users/hmmini/Downloads/IMG_5233.jpg");
             OutputStream out = new FileOutputStream("/Users/hmmini/Downloads/IMG_5233.jpg")) {
            // 입력 스트림에서 읽고 출력 스트림에 쓰는 로직
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
