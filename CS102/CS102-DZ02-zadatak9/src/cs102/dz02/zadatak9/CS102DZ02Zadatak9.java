/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz02.zadatak9;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ02Zadatak9 extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField tf = new TextField();

        FlowPane root = new FlowPane();
        root.getChildren().add(tf);

        Scene scene = new Scene(root, 300, 250);
        scene.setOnKeyPressed(e -> {

            char[] text = tf.getText().toCharArray();
            for (char c : text) {
                System.out.println(text);
                Label l = new Label(c + " " + kreirajKaraktere(c));
                root.getChildren().add(l);

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

    private String kreirajKaraktere(char c) {
        String chara = "" + c;
        Integer integer = Integer.valueOf(chara);
        String s = "";
        String addString = ".";
        if (integer % 2 == 0) {
            addString = "-";
        }
        for (int i = 0; i < integer; i++) {
            s += addString;
            System.out.println(s);
        }

        return s;
    }

}
