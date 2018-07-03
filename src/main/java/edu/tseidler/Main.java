package edu.tseidler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        primaryStage.setTitle("Hello World");

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Scene scene = new Scene(root, 0, 0);
        primaryStage.setScene(scene);

        primaryStage.setWidth(primaryScreenBounds.getWidth() / 3);
        primaryStage.setHeight(primaryScreenBounds.getHeight() / 3);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
