package com.example.testspring.demo.views;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class loginView {
    public Scene getScene() {
        VBox root = new VBox(new Label("¡Hola desde la nueva vista!"));
        return new Scene(root, 400, 300);
    }
}