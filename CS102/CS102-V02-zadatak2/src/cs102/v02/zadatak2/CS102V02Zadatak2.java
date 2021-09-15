/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v02.zadatak2;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author vikto
 */
public class CS102V02Zadatak2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Rectangle rt = new Rectangle(20, 20);
        rt.setFill(Color.RED);
        Path path = new Path();
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 299 + 1);
            int y = (int) (Math.random() * 399 + 1);
            Circle c = new Circle(x, y, 5);
            root.getChildren().add(c);
            if (i == 0) {
                path.getElements().add(new MoveTo(x, y));
            } else {
                path.getElements().add(new LineTo(x, y));
            }
        }
        root.getChildren().add(rt);
        root.getChildren().add(path);
        PathTransition pt = new PathTransition(Duration.millis(5000), path, rt);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.play();
        FadeTransition ft = new FadeTransition(Duration.millis(5000), rt);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setAutoReverse(true);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.play();

        Scene scene = new Scene(root, 400, 400);

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
