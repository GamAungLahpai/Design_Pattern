public class Demo {
    public static void main(String[] args) {
        // Create handlers
        Handler compensationHandler = new CompensationClaimHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler developmentHandler = new DevelopmentSuggestionHandler();
        Handler generalHandler = new GeneralFeedbackHandler();

        // Build chain
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalHandler);

        // Create test messages
        Message m1 = new Message(
                MessageType.COMPENSATION_CLAIM,
                "I want a refund because the product was broken when it arrived.",
                "customer1@email.com"
        );

        Message m2 = new Message(
                MessageType.CONTACT_REQUEST,
                "Please contact me about my recent order.",
                "customer2@email.com"
        );

        Message m3 = new Message(
                MessageType.DEVELOPMENT_SUGGESTION,
                "It would be great to add dark mode to the app.",
                "customer3@email.com"
        );

        Message m4 = new Message(
                MessageType.GENERAL_FEEDBACK,
                "Your service was very good and delivery was fast.",
                "customer4@email.com"
        );

        Message m5 = new Message(
                MessageType.COMPENSATION_CLAIM,
                "I am unhappy with the service.",
                "customer5@email.com"
        );

        // Process messages
        System.out.println(compensationHandler.handle(m1));
        System.out.println(compensationHandler.handle(m2));
        System.out.println(compensationHandler.handle(m3));
        System.out.println(compensationHandler.handle(m4));
        System.out.println(compensationHandler.handle(m5));
    }
}