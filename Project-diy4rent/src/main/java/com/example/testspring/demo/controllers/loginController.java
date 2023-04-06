package com.example.testspring.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.testspring.demo.views.loginView; //no se si esto está bien, no consigo solucionar el error: 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class loginController extends Application {
    @GetMapping("/loginView")
    public void start(Stage primaryStage) throws Exception {
        Button boton = new Button("CONTROLADOR LOGIN NUEVA VISTA");
        boton.setOnAction(event -> {
            Scene nuevaScene = new loginView().getScene();
            primaryStage.setScene(nuevaScene);
        });
        
        Scene scene = new Scene(new StackPane(boton), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
