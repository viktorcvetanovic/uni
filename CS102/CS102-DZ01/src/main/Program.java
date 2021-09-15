/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class Program extends Application {

    @Override
    public void start(Stage primaryStage) {

        CheckBox checkBox1 = new CheckBox("Bold");
        CheckBox checkBox2 = new CheckBox("Italic");
        CheckBox checkBox3 = new CheckBox("Underline");

        GridPane firstRow = new GridPane();
        firstRow.setVgap(5);
        firstRow.add(checkBox1, 0, 0);
        firstRow.add(checkBox2, 0, 1);
        firstRow.add(checkBox3, 0, 2);
        firstRow.setPadding(new Insets(10, 0, 0, 10));
        CheckBox checkBox4 = new CheckBox("Strikethrought");
        CheckBox checkBox5 = new CheckBox("Teletype");
        CheckBox checkBox6 = new CheckBox("Emphasis");
        CheckBox checkBox7 = new CheckBox("Strong");

        GridPane secondRow = new GridPane();
        secondRow.setVgap(5);
        secondRow.add(checkBox4, 0, 0);
        secondRow.add(checkBox5, 0, 1);
        secondRow.add(checkBox6, 0, 2);
        secondRow.add(checkBox7, 0, 3);
        secondRow.setPadding(new Insets(10, 0, 0, 10));
        GridPane thirdRow = new GridPane();
        Label lb = new Label("Sample Text");
        Button btn = new Button("Apply");
        TextArea tf = new TextArea();
        tf.setPromptText("This is sample text");
        tf.setMaxWidth(150);
        tf.setMaxHeight(80);
        thirdRow.add(lb, 0, 0);
        thirdRow.add(tf, 0, 1);
        thirdRow.add(btn, 0, 2);
        GridPane.setHalignment(btn, HPos.CENTER);
        thirdRow.setPadding(new Insets(10, 0, 0, 0));

//        root.getChildren().add(btn);
//        root.getChildren().add(checkBox1);
        GridPane mainPane = new GridPane();
        mainPane.add(firstRow, 0, 0);
        mainPane.add(secondRow, 1, 0);
        mainPane.add(thirdRow, 2, 0);
        mainPane.setHgap(20);
        mainPane.setStyle("-fx-background-color:aqua");
        Scene scene = new Scene(mainPane, 400, 150);

        primaryStage.setTitle("Viktor Cvetanovic 4421 ");
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
