/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz03.zadatak7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class Main extends Application {

    TextField ti;
    ComboBox comboBox;
    Button izaberiBrojPokusaja = new Button("Izaberi");

    BorderPane root;
    Image image;
    ImageView imgView;
    int result = 0;
    int brojPokusaja;

    int PCpobede = 0;
    int PlayerPobede = 0;
    ObservableList<IzborPoteza> potezi = FXCollections.observableArrayList(new IzborPoteza("kamen", "https://www.kindpng.com/picc/m/36-363363_hand-clip-svg-paper-hand-sign-game-hd.png", 1),
            new IzborPoteza("papir", "https://img.favpng.com/15/6/8/rock-paper-scissors-game-png-favpng-cDPmDhsHCWHEgPFiRtJPYBFKx.jpg", 2),
            new IzborPoteza("makaze", "https://img.favpng.com/15/6/8/rock-paper-scissors-game-png-favpng-cDPmDhsHCWHEgPFiRtJPYBFKx.jpg", 3));

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        //firstmenu
        createFirstMenu();

        izaberiBrojPokusaja.setOnAction(e -> {
            brojPokusaja = Integer.valueOf(ti.getText());
            root.getChildren().clear();
            createGameMenu();
        });

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("Papir kamen makaze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void proveriPobednika(int player, int PC) {
        System.out.println(player);
        System.out.println(PC);
        Text t3 = new Text();
        t3.setFont(Font.font(36));
        t3.setFill(Paint.valueOf("red"));
        BorderPane.setAlignment(t3, Pos.CENTER);
        result++;
        if (player == PC) {
            System.out.println("Izjednaceno");
            t3.setText("Izjednaceno");
            root.setCenter(t3);
        }
        if (player > PC && player - 1 == PC || player == 1 && PC == 3) {
            System.out.println("Player je pobednik");
            t3.setText("Igrac je dobio rundu");
            root.setCenter(t3);
            PlayerPobede++;
        } else if (player < PC && PC - 1 == player || player == 3 && PC == 1) {
            System.out.println("PC JE POBEDIO");
            t3.setText("PC je dobio rundu");
            root.setCenter(t3);
            PCpobede++;
        }
    }

    public IzborPoteza PCPotez() {
        int randomNumber = (int) (Math.random() * 2 + 1);
        IzborPoteza potez = (IzborPoteza) potezi.get(randomNumber);
        return potez;
    }

    public void createFirstMenu() {
        VBox vbox = new VBox();
        Label l = new Label("Unesi broj ponavljaja");
        ti = new TextField();
        vbox.getChildren().addAll(l, ti, izaberiBrojPokusaja);
        vbox.setMaxWidth(200);
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);
    }

    public void createGameMenu() {
        VBox vbox = new VBox();
        Label l = new Label("Izaberi potez");
        comboBox = new ComboBox(potezi);
        vbox.getChildren().addAll(l, comboBox);
        vbox.setMaxWidth(200);
        vbox.setAlignment(Pos.CENTER);
        VBox.setMargin(comboBox, new Insets(10, 0, 10, 0));
        root.setRight(vbox);

        comboBox.valueProperty().addListener(e -> {

            IzborPoteza potez = (IzborPoteza) comboBox.getValue();
            IzborPoteza PCpotez = PCPotez();
            if (brojPokusaja == 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("KRAJ");
                if (PlayerPobede > PCpobede) {
                    alert.setHeaderText("PLAYER JE POBEDIO");
                } else if (PlayerPobede == PCpobede) {
                    alert.setHeaderText("NERESENO JE");
                } else {
                    alert.setHeaderText("PC JE POBEDIO");
                }
                PCpobede = 0;
                PlayerPobede = 0;
                alert.show();
                root.getChildren().clear();
                createFirstMenu();
            } else {

                brojPokusaja -= 1;
                proveriPobednika(potez.getBrojPoteza(), PCpotez.getBrojPoteza());
                Text t2 = new Text("PC je izabrao: " + PCpotez.getName());
                Text poeni = new Text("Player Poeni: " + PlayerPobede + " PC Poeni: " + PCpobede + "\n" + "Igrac je izabrao: " + potez.getName());
                poeni.setFont(Font.font(32));
                t2.setFont(Font.font(32));
                root.setTop(poeni);

                root.setBottom(t2);
                BorderPane.setAlignment(poeni, Pos.CENTER);
                BorderPane.setAlignment(t2, Pos.CENTER);
            }

        });

    }
}
