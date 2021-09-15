/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz02.zadatak4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ02Zadatak4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        napraviKrugove(root);
        Scene scene = new Scene(root, 400, 400);
        scene.setOnMouseClicked(e -> {
            root.getChildren().clear();
            napraviKrugove(root);
        });
        primaryStage.setTitle("Zadatak 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void napraviKrugove(Pane root) {
        final int RADIUS = 10;
        for (int i = 0; i < 5; i++) {
            int randomX = (int) (Math.random() * 259 + 1);
            int randomY = (int) (Math.random() * 299 + 1);
            Circle c = new Circle(randomX, randomY, RADIUS);
            root.getChildren().add(c);

        }
    }
}
