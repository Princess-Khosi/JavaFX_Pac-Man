package com.example.javafx_pacman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameplayApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameplayApplication.class.getResource("empty_world.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Gameplay");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
