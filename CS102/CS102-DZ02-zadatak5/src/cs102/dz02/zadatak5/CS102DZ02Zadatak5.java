/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz02.zadatak5;

import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author vikto
 */
public class CS102DZ02Zadatak5 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Circle c = new Circle(10);
        MoveTo move = new MoveTo(0, 240);
        LineTo line = new LineTo(300, 240);
        Path path = new Path(move, line);
        path.setVisible(false);
        root.getChildren()
                .add(path);
        root.getChildren()
                .add(c);

        PathTransition pt = new PathTransition(Duration.millis(5000), path, c);
        pt.setAutoReverse(true);
        pt.setCycleCount(INDEFINITE);
        pt.play();
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
