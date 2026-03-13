package org.example.memento;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

import java.util.stream.Collectors;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    private ListView<String> historyListView;

    public void start(Stage stage) {
        controller = new Controller(this);

        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Label label = new Label("Press Ctrl-Z to undo and Ctrl-Y to redo.");
        label.setPadding(insets);

        VBox vBox = new VBox(hBox, checkBox, label);

        checkBox.setOnAction(event -> controller.setIsSelected(checkBox.isSelected()));

        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

        createHistoryWindow();
        refreshHistory();
    }

    private void createHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History");

        historyListView = new ListView<>();

        historyListView.setOnMouseClicked(event -> {
            int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                controller.restoreFromHistory(selectedIndex);
            }
        });

        VBox root = new VBox(new Label("Saved States"), historyListView);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene historyScene = new Scene(root, 450, 300);
        historyStage.setScene(historyScene);
        historyStage.show();
    }

    public void refreshHistory() {
        if (historyListView != null) {
            historyListView.setItems(FXCollections.observableArrayList(
                    controller.getStateHistory()
                            .stream()
                            .map(IMemento::getDisplayText)
                            .collect(Collectors.toList())
            ));
        }
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }
}