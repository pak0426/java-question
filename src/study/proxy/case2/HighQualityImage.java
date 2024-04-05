package study.proxy.case2;

 class HighQualityImage implements Image {

     String img;

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

     @Override
     public void showImage() {

     }
 }
