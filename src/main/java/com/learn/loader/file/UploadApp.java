package com.learn.loader.file;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.function.Consumer;

public class UploadApp extends Application {

    private Consumer<File> onFileLoaded;

    public static void main(String[] args) {
        UploadApp.launch(args);
    }

    @Override
    public void start(Stage stage) {
        CheckGrammarAction grammarAction = new CheckGrammarAction();
        setOnFileLoaded(grammarAction::check);

        stage.setTitle("English words learn");
        FileUploader uploader = new FileUploader();
        Button openButton = new Button("Select source file");
        Button checkResultButton = new Button("Select test result file");

        openButton.setOnAction(uploadFile(stage, uploader));

        checkResultButton.setOnAction(uploadFile(stage, uploader));

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 0);
        GridPane.setConstraints(checkResultButton, 1, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton, checkResultButton);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        final Insets insets = new Insets(12, 12, 12, 12);
        rootGroup.setPadding(insets);

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    private EventHandler<ActionEvent> uploadFile(Stage stage, FileUploader uploader) {
        return e -> {
            File file = uploader.openChooser(stage);
            if (file != null) {
                this.onFileLoaded.accept(file);
            }
        };
    }

    public void setOnFileLoaded(Consumer<File> onFileLoaded) {
        this.onFileLoaded = onFileLoaded;
    }
}
