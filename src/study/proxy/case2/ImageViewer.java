package study.proxy.case2;

class ImageViewer {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("/img/이미지1");
        Image img2 = new ProxyImage("/img/이미지2");
        Image img3 = new ProxyImage("/img/이미지3");

        img2.showImage();
    }
}
