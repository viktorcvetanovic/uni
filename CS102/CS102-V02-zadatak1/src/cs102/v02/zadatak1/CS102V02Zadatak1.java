/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v02.zadatak1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102V02Zadatak1 extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        Label l1 = new Label("Unesi Stranicu a");
        TextField a = new TextField();
        Label l2 = new Label("Unesi stranicu b");
        TextField b = new TextField();
        root.setHgap(10);
        root.setVgap(10);
        HBox hb = new HBox();
        Button btn = new Button("Izracunaj");
        hb.getChildren().add(btn);

        btn.setOnAction(e -> {
            Integer value1 = Integer.valueOf(a.getText());
            Integer value2 = Integer.valueOf(b.getText());
            Integer value = value1 + value2;
            String valueString = String.valueOf(value);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, valueString, ButtonType.OK);
            alert.show();
        });
        root.setAlignment(Pos.CENTER);
        root.add(l1, 0, 0);
        root.add(a, 1, 0);
        root.add(l2, 0, 1);
        root.add(b, 1, 1);
        root.add(hb, 0, 2);
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
