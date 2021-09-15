/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz03.zadatak10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ03Zadatak10 extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        //IGRAC ONE
        ProgressBar pg1 = new ProgressBar(1);
        Button b1 = new Button("Attack");

        //IGRAC TWO
        ProgressBar pg2 = new ProgressBar(1);
        pg2.setStyle("-fx-accent: red; ");
        Button b2 = new Button("Attack");

        //adding elements
        root.add(pg1, 0, 0);
        root.add(b1, 1, 0);
        root.add(pg2, 0, 1);
        root.add(b2, 1, 1);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        Button resetButton = new Button("Play Again");
        //ACTIONS
        b1.setOnAction(e -> {
            if (pg2.getProgress() <= 0) {
                root.getChildren().clear();
                root.add(resetButton, 0, 0);
            }
            pg2.setProgress(pg2.getProgress() - Math.random());
        });

        b2.setOnAction(e -> {
            if (pg1.getProgress() <= 0) {
                root.getChildren().clear();
                root.add(resetButton, 0, 0);
            }
            pg1.setProgress(pg1.getProgress() - Math.random());
        });

        resetButton.setOnAction(e -> {

        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
