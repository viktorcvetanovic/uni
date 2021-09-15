/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v03.zadatak3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102V03Zadatak3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle c = new Circle(150, 150, 5);
        Pane root = new Pane();
        root.getChildren().add(c);

        Scene scene = new Scene(root, 400, 400);
        scene.setOnKeyPressed(e -> {

            if (e.getCode() == KeyCode.LEFT) {
                Circle c2 = new Circle(c.getCenterX() - 10, c.getCenterY(), 5);
                root.getChildren().add(c2);
                c.setCenterX(c.getCenterX() - 10);

            } else if (e.getCode() == KeyCode.RIGHT) {
                Circle c2 = new Circle(c.getCenterX() + 10, c.getCenterY(), 5);
                root.getChildren().add(c2);
                c.setCenterX(c.getCenterX() + 10);

            } else if (e.getCode() == KeyCode.UP) {
                Circle c2 = new Circle(c.getCenterX(), c.getCenterY() - 10, 5);
                root.getChildren().add(c2);
                c.setCenterY(c.getCenterY() - 10);

            } else if (e.getCode() == KeyCode.DOWN) {
                Circle c2 = new Circle(c.getCenterX(), c.getCenterY() + 10, 5);
                root.getChildren().add(c2);
                c.setCenterY(c.getCenterY() + 10);
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
