package study.proxy.case1;

 class HighQualityImage {
     private String img;

     HighQualityImage(String path) {
         load(path);
     }
     public void load(String path) {
         try {
             Thread.sleep(1000);
             img = path;
             System.out.println(img + " 이미지 로딩완료");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

     public void show() {
         System.out.println("이미지 출력 = " + img);
     }

 }
