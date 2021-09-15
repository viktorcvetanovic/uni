/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v03.zadatak1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author vikto
 */
public class CS102V03Zadatak1 extends Application {

    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Pane animationPane = new Pane();
        Circle c = new Circle(150, 150, 50);
        animationPane.getChildren().add(c);
        Scene scene = new Scene(root, 300, 300);
        HBox box = new HBox();
        cb1 = new CheckBox("Translate Transition");
        cb2 = new CheckBox("Scale Transition");
        cb3 = new CheckBox("Fade Transition");
        box.getChildren().addAll(cb1, cb2, cb3);

        root.setTop(box);
        root.setCenter(animationPane);

        //Fade Transition
        FadeTransition fd = new FadeTransition(Duration.millis(5000), c);
        fd.setAutoReverse(true);
        fd.setCycleCount(-1);
        fd.setFromValue(5);
        fd.setToValue(0);

        //Scale Transition
        ScaleTransition st = new ScaleTransition();
        st.setNode(c);
        st.setDuration(Duration.millis(2000));
        st.setAutoReverse(true);
        st.setCycleCount(-1);
        st.setByX(10);

        //Translate Transition
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(c);
        tt.setDuration(Duration.millis(2000));
        tt.setAutoReverse(true);
        tt.setCycleCount(-1);
        tt.setByX(30);

        cb1.setOnAction(e -> {
            if (cb1.isSelected()) {
                tt.play();
            } else {
                tt.pause();
            }
        });
        cb2.setOnAction(e -> {
            if (cb2.isSelected()) {
                st.play();
            } else {
                st.pause();
            }
        });
        cb3.setOnAction(e -> {
            if (cb3.isSelected()) {
                fd.play();
            } else {
                fd.pause();
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
