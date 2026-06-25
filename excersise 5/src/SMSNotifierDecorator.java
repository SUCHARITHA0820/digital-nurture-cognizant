// SMSNotifierDecorator.java
public class SMSNotifierDecorator extends NotifierDecorator {
    
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Sends the previous channels (e.g., Email)
        sendSMS(message);    // Adds SMS functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
