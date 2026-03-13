public class ContactRequestHandler extends Handler {

    @Override
    public String handle(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            return "Contact Request Handler: Contact request from " + message.getSenderEmail()
                    + " forwarded to customer service.";
        }

        if (nextHandler != null) {
            return nextHandler.handle(message);
        }

        return "No handler found for message.";
    }
}