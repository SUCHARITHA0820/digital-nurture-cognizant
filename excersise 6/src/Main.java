// Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. Creating Proxy Image ---");
        // At this point, no network call or heavy loading has happened.
        Image image = new ProxyImage("nature_wallpaper_4k.jpg");
        System.out.println("Proxy object created. No network lag encountered yet.");

        System.out.println("\n--- 2. First Display Call (Lazy Loading) ---");
        // This will trigger the remote network download
        image.display();

        System.out.println("\n--- 3. Second Display Call (Caching) ---");
        // This will skip the network download entirely and display immediately
        image.display();
    }
}