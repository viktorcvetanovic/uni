/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_zadatak1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author hrist
 */
public class NewFXMain extends Application {

    Font fontNormal = Font.font("Ariel", FontWeight.LIGHT, FontPosture.REGULAR, 28);
    Font fontBold = Font.font("Ariel", FontWeight.BOLD, FontPosture.REGULAR, 28);
    Font fontItalic = Font.font("Ariel", FontWeight.LIGHT, FontPosture.ITALIC, 28);
    Font fontItalicBold = Font.font("Ariel", FontWeight.BOLD, FontPosture.ITALIC, 28);
    CheckBox cb1, cb2;
    Text poruka;

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("Levo");
        Button btn2 = new Button();
        btn2.setText("Desno");
        Button btn3 = new Button();
        btn3.setText("Gore");
        Button btn4 = new Button();
        btn4.setText("Dole");
        Button btn5 = new Button();
        btn5.setText("Zatvori");

        HBox hb1 = new HBox(10);
        hb1.setAlignment(Pos.CENTER);
        hb1.setStyle("-fx-background-color: lightblue;");
        hb1.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);

        poruka = new Text("CS102- pokazniPrimer");
        poruka.setFont(fontNormal);
        poruka.setFill(Color.RED);
        Pane pn = new Pane();
        poruka.setX(65);
        poruka.setY(130);
        pn.getChildren().add(poruka);

        btn1.setOnAction(e -> {
            poruka.setX(poruka.getX() - 10);
        });
        btn2.setOnAction(e -> {
            poruka.setX(poruka.getX() + 10);
        });
        btn3.setOnAction(e -> {
            poruka.setY(poruka.getY() - 10);
        });
        btn4.setOnAction(e -> {
            poruka.setY(poruka.getY() + 10);
        });
        btn5.setOnAction(e -> {
            Platform.exit();
        });

        cb1 = new CheckBox("Bold");
        cb2 = new CheckBox("Italic");

        VBox vb1 = new VBox(10);
        vb1.setAlignment(Pos.CENTER_LEFT);
        vb1.setStyle("-fx-background-color: lightgreen;");
        vb1.getChildren().addAll(cb1, cb2);
        
        CheckBoxObrada cbo = new CheckBoxObrada();
        cb1.setOnAction(cbo);
        cb2.setOnAction(cbo);
        
        RadioButton rb1 = new RadioButton("Crvena");
        RadioButton rb2 = new RadioButton("Zelena");
        RadioButton rb3 = new RadioButton("Plava");
        VBox vb2 = new VBox(10);
        vb2.setAlignment(Pos.CENTER_LEFT);
        vb2.setStyle("-fx-background-color: lightgreen;");
        vb2.getChildren().addAll(rb1, rb2, rb3);
        
        ToggleGroup tg1 = new ToggleGroup();
        rb1.setToggleGroup(tg1);
        rb2.setToggleGroup(tg1);
        rb3.setToggleGroup(tg1);
        
        rb1.setOnAction(e-> {
            if (rb1.isSelected()) {
                poruka.setFill(Color.RED);
            }
        });
        rb2.setOnAction(e-> {
            if (rb2.isSelected()) {
                poruka.setFill(Color.GREEN);
            }
        });
        rb3.setOnAction(e-> {
            if (rb3.isSelected()) {
                poruka.setFill(Color.BLUE);
            }
        });
        
        Label lb1 = new Label("Unesite tekst");
        TextField tf1 = new TextField();
        tf1.setPromptText("Tekst ovde");
        Button unesiBtn = new Button("Promeni");
        HBox hb2 = new HBox(10);
        hb2.setAlignment(Pos.CENTER);
        hb2.setStyle("-fx-background-color: lightblue;");
        hb2.getChildren().addAll(lb1, tf1, unesiBtn);
        
        tf1.setOnAction(e -> {
            poruka.setText(tf1.getText());
        });
        unesiBtn.setOnAction(e -> {
            poruka.setText(tf1.getText());
        });

        BorderPane root = new BorderPane();
        root.setBottom(hb1);
        root.setCenter(pn);
        root.setRight(vb1);
        root.setLeft(vb2);
        root.setTop(hb2);
        

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("L3-P1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class CheckBoxObrada implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (cb1.isSelected() && cb2.isSelected()) {
                poruka.setFont(fontItalicBold);
            } else if (cb1.isSelected()) {
                poruka.setFont(fontBold);
            } else if (cb2.isSelected()) {
                poruka.setFont(fontItalic);
            } else {
                poruka.setFont(fontNormal);
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
