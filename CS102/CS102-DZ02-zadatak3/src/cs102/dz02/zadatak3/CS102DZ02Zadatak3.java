/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz02.zadatak3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ02Zadatak3 extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        FileChooser fileChooser = new FileChooser();
        Button button = new Button("Add file");
        root.add(button, 0, 0);
        button.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            try {
                ispisiSadrzajFajla(selectedFile);
            } catch (IOException ex) {
                Logger.getLogger(CS102DZ02Zadatak3.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
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

    public static void ispisiSadrzajFajla(File f) throws FileNotFoundException, IOException {
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String line = null;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }

}
