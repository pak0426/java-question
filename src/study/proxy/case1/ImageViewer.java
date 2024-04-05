package study.proxy.case1;

class ImageViewer {
    public static void main(String[] args) {
        HighQualityImage image1 = new HighQualityImage("./img/이미지1");
        HighQualityImage image2 = new HighQualityImage("./img/이미지2");
        HighQualityImage image3 = new HighQualityImage("./img/이미지3");

        image2.show();
    }
}
