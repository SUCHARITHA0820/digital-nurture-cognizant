// SlackNotifierDecorator.java
public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Sends previous channels
        sendSlackMessage(message); // Adds Slack functionality
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}
