public class GeneralFeedbackHandler extends Handler {

    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            return "General Feedback Handler: Feedback from " + message.getSenderEmail()
                    + " analyzed and response prepared.";
        }

        if (nextHandler != null) {
            return nextHandler.handle(message);
        }

        return "No handler found for message.";
    }
}