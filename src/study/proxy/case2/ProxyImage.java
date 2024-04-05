package study.proxy.case2;

public class ProxyImage implements Image {

    private Image proxyImage;
    private String path;

    public ProxyImage(String path) {
        this.path = path;
    }

    @Override
    public void showImage() {
        proxyImage = new HighQualityImage(path);
        proxyImage.showImage();
    }
}
