public class Main {
    public static void main(String[] args) {
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        
        System.out.println("Client: Using PayPal Adapter...");
        payPalProcessor.processPayment(150.00);

        System.out.println("---------------------------------------------");

        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        
        System.out.println("Client: Using Stripe Adapter...");
        stripeProcessor.processPayment(250.50);
    }
}
