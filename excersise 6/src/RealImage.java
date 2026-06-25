// RealImage.java
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Connecting to remote server... 🌐");
        System.out.println("Downloading and loading: " + filename);
        try {
            // Simulating network delay
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying high-resolution image: " + filename);
    }
}
