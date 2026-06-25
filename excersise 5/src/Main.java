// Main.java
public class Main {
    public static void main(String[] args) {
        String alertMessage = "System Alert: Server load is high!";

        System.out.println("--- Scenario 1: Base Email Notification Only ---");
        Notifier basicEmail = new EmailNotifier();
        basicEmail.send(alertMessage);
        
        System.out.println("\n--- Scenario 2: Email + SMS Notification ---");
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSMS.send(alertMessage);

        System.out.println("\n--- Scenario 3: Email + SMS + Slack Notification ---");
        // We dynamically stack decorators on top of each other
        Notifier fullStackNotification = new SlackNotifierDecorator(
                                            new SMSNotifierDecorator(
                                                new EmailNotifier()
                                            ));
        fullStackNotification.send(alertMessage);
    }
}
