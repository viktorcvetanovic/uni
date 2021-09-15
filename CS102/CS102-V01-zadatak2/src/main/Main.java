/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import static main.Util.randomNumber;

/**
 *
 * @author vikto
 */
public class Main extends Application {

    private GridPane root = new GridPane();

    @Override
    public void start(Stage primaryStage) {
        int number = randomNumber();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                Circle c = new Circle(15, Color.color(Math.random(), Math.random(), Math.random()));
                root.add(c, j, i);
            }
        }

        Scene scene = new Scene(root, 300, 250);

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
