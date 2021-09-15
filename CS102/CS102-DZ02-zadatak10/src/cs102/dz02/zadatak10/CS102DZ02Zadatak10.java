/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz02.zadatak10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ02Zadatak10 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Path path = new Path();

        CubicCurve cubic = new CubicCurve();
        cubic.setStartX(0.0f);
        cubic.setStartY(50.0f);
        cubic.setControlX1(25.0f);
        cubic.setControlY1(0.0f);
        cubic.setControlX2(75.0f);
        cubic.setControlY2(100.0f);
        cubic.setEndX(100.0f);
        cubic.setEndY(50.0f);

        //path.getElements().add(cubic);
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
