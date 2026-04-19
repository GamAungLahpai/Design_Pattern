package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        ChatMediator mediator = new ChatMediatorImpl();

        // Create 3 clients (minimum requirement)
        ChatClientController client1 = new ChatClientController("Alice", mediator);
        ChatClientController client2 = new ChatClientController("Bob", mediator);
        ChatClientController client3 = new ChatClientController("Charlie", mediator);

        // Set selectable users
        client1.getUserSelector().getItems().addAll("Bob", "Charlie");
        client2.getUserSelector().getItems().addAll("Alice", "Charlie");
        client3.getUserSelector().getItems().addAll("Alice", "Bob");

        // Create windows
        createStage(client1, "Alice");
        createStage(client2, "Bob");
        createStage(client3, "Charlie");
    }

    private void createStage(ChatClientController client, String title) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(client.getView(), 300, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}