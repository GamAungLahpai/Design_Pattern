public class DevelopmentSuggestionHandler extends Handler {

    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            return "Development Suggestion Handler: Suggestion from " + message.getSenderEmail()
                    + " logged and marked for prioritization.";
        }

        if (nextHandler != null) {
            return nextHandler.handle(message);
        }

        return "No handler found for message.";
    }
}