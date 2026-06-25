// ProxyImage.java
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
        // Notice: We DO NOT load the real image here in the constructor!
    }

    @Override
    public void display() {
        // Caching & Lazy Initialization check
        if (realImage == null) {
            System.out.println("[Proxy] Image not loaded yet. Fetching from server...");
            realImage = new RealImage(filename); // Initialized on demand
        } else {
            System.out.println("[Proxy] Image retrieved instantly from cache.");
        }
        
        // Delegate the actual display work to the real object
        realImage.display();
    }
}
