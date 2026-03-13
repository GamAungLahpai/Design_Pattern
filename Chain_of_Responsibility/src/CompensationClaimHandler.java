public class CompensationClaimHandler extends Handler {

    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            // simple demo logic
            if (message.getContent().toLowerCase().contains("refund")
                    || message.getContent().toLowerCase().contains("broken")
                    || message.getContent().toLowerCase().contains("damaged")) {
                return "Compensation Claim Handler: Claim from " + message.getSenderEmail()
                        + " reviewed and APPROVED.";
            } else {
                return "Compensation Claim Handler: Claim from " + message.getSenderEmail()
                        + " reviewed and REJECTED.";
            }
        }

        if (nextHandler != null) {
            return nextHandler.handle(message);
        }

        return "No handler found for message.";
    }
}