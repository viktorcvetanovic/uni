/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_zadatak1;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author hrist
 */
public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label lb1 = new Label("Unesite korisnicko ime");
        Label lb2 = new Label("Unesite lozinku");
        TextField userName = new TextField();
        TextField pass = new PasswordField();
        userName.setAlignment(Pos.BASELINE_RIGHT);

        Button login = new Button("Prijavite se");
        login.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
        });

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(lb1, 0, 0);
        root.add(userName, 1, 0);
        root.add(lb2, 0, 1);
        root.add(pass, 1, 1);
        root.add(login, 1, 2);
        GridPane.setHalignment(login, HPos.RIGHT);

        login.setOnAction(e -> {
            if (userName.getText().equals("user") && pass.getText().equals("1234")) {
                primaryStage.close();
//              new NewFXMain().start(primaryStage); 
                NewFXMain m = new NewFXMain();
                m.start(primaryStage);
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Login");
                a.setHeaderText("Neuspesno prijavljivanje");
                a.setContentText("Netacni podaci");
                a.showAndWait();
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

}
