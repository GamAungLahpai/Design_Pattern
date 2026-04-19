package org.example;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ChatClientController {

    private final String username;
    private final ChatMediator mediator;

    private TextArea chatArea;
    private TextField messageField;
    private ComboBox<String> userSelector;
    private Button sendButton;

    public ChatClientController(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);

        createUI();
    }

    private void createUI() {
        chatArea = new TextArea();
        chatArea.setEditable(false);

        messageField = new TextField();

        userSelector = new ComboBox<>();

        sendButton = new Button("Send");

        sendButton.setOnAction(e -> sendMessage());
    }

    public VBox getView() {
        return new VBox(10, chatArea, userSelector, messageField, sendButton);
    }

    public String getUsername() {
        return username;
    }

    public ComboBox<String> getUserSelector() {
        return userSelector;
    }

    private void sendMessage() {
        String message = messageField.getText();
        String receiver = userSelector.getValue();

        if (message != null && receiver != null) {
            mediator.sendMessage(message, this, receiver);
            chatArea.appendText("Me -> " + receiver + ": " + message + "\n");
            messageField.clear();
        }
    }

    public void receiveMessage(String sender, String message) {
        chatArea.appendText(sender + ": " + message + "\n");
    }
}