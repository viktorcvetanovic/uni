/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class Main extends Application {

    private GridPane root = new GridPane();
    private Scene scene = new Scene(root, 300, 300);

    @Override
    public void start(Stage primaryStage) {
        int number = 2;
        Circle c = new Circle(15, Color.BLACK);

        switch (number) {
            case 1:
                root.add(c, 1, 1);
                root.setAlignment(Pos.CENTER);
            case 2:
                Circle c1 = new Circle(15);
                Circle c2 = new Circle(50, Color.TRANSPARENT);
                c.radiusProperty().bind(scene.widthProperty().divide(6));
                c1.radiusProperty().bind(scene.widthProperty().divide(6));
                root.add(c1, 2, 2);
                root.add(c, 0, 0);
                root.add(c2, 1, 1);

        }

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

    public static int randomNumber() {
        return (int) Math.floor(Math.random() * 6 + 1);
    }
}
