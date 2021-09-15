/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz08.zadatak3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    public static Rectangle rec;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 300, 250);
        rec = new Rectangle();
        rec.widthProperty().bind(scene.widthProperty());
        rec.heightProperty().bind(scene.heightProperty());
        root.setCenter(rec);
        Thread thread = new Thread(new ChangeColor());
        Thread thread2 = new Thread(new ChangeVisibility());
        thread.start();
        thread2.start();
        primaryStage.setTitle("Zadatak");
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
