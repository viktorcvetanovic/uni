/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v03.zadatak2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102V03Zadatak2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        TextField f = new TextField();
        Scene scene = new Scene(root, 300, 250);

        scene.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                Circle c = new Circle(e.getX(), e.getY(), 5);

                root.getChildren().add(c);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                root.getChildren().clear();
            }

        });

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
