/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v02.zadatak3;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102V02Zadatak3 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Text t = new Text();
        GridPane root = new GridPane();

        root.add(t, 0, 0);
        Scene scene = new Scene(root, 300, 250);
        scene.setOnKeyPressed(e -> {

            KeyCode s = e.getCode();
            String string = s.toString();
            ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(string);

            t.setText(t.getText() + byteBuffer);

        });
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
