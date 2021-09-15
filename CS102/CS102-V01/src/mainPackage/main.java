/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Login");
        
        Label naslov = new Label("LOGIN");
        naslov.setTextFill(Color.RED);
        Label email = new Label("Email: ");
        TextField tfForEmail = new TextField();
        
        Label password = new Label("Password :");
        TextField tfForPassword = new PasswordField();
        
        GridPane root = new GridPane();
        root.add(naslov, 1, 0);
        root.add(email, 0, 1);
        root.add(tfForEmail, 1, 1);
        root.add(password, 0, 2);
        root.add(tfForPassword, 1, 2);
        root.add(btn, 1, 3);
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle(
                "Login Form");
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
