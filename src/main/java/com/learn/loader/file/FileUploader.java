package com.learn.loader.file;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class FileUploader {

    private FileChooser chooser;

    public FileUploader() {
        this.chooser = new FileChooser();
        chooser.setTitle("Select file");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }

    public File openChooser(Window window) {
        return chooser.showOpenDialog(window);
    }
}
