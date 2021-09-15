/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz03.zadatak1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ03Zadatak1 extends Application {

    //Button value
    String s = "";
    int randomBroj = 1;
    static List<Integer> sviBrojevi = new ArrayList<Integer>();

    @Override
    public void start(Stage primaryStage) {

        //values
        Map<Integer, String[]> map = new HashMap<Integer, String[]>();
        map.put(1, new String[]{"Koliko je 2+2", "2", "3", "4", "4"});
        map.put(2, new String[]{"Koji je glavni grad Srbije", "Nis", "Leskovac", "Beograd", "Beograd"});
        map.put(3, new String[]{"Koji je najveci grad na svetu", "Lisabon", "Tokyo", "New York", "Tokyo"});
        map.put(4, new String[]{"Najbrza zivotinja na svetu", "Tigas", "Leopard", "Gepard", "Gepard"});

        //buttons
        Button btn = new Button();
        btn.setText("Zapocni kviz");

        //tougleGroup
        ToggleGroup toggleGroup = new ToggleGroup();

        //radiobuttons
        VBox box = new VBox();
        RadioButton btn1 = new RadioButton();
        RadioButton btn2 = new RadioButton();
        RadioButton btn3 = new RadioButton();
        btn1.setToggleGroup(toggleGroup);
        btn2.setToggleGroup(toggleGroup);
        btn3.setToggleGroup(toggleGroup);
        box.getChildren().addAll(btn1, btn2, btn3);

        //label
        Label l = new Label("DOBRODOSLI U KVIZ");

        BorderPane root = new BorderPane();
        root.setTop(l);
        root.setBottom(btn);
        BorderPane.setAlignment(btn, Pos.CENTER);
        BorderPane.setAlignment(l, Pos.CENTER);

        //end scene
        Label endLabel = new Label("Uspesno ste presli kviz");
        Button exit = new Button("Izadji");

        Scene scene = new Scene(root, 300, 250);

        btn.setOnAction(e -> {

            if (map.get(randomBroj)[4].equals(s) || btn.getText().equals("Zapocni kviz")) {

                randomBroj = randomNumber();
                if (randomBroj == 0) {
                    root.getChildren().clear();
                    root.setCenter(endLabel);
                    root.setBottom(exit);
                    BorderPane.setAlignment(exit, Pos.CENTER);
                } else {
                    root.setCenter(box);
                    btn1.setText(map.get(randomBroj)[1]);
                    btn2.setText(map.get(randomBroj)[2]);
                    btn3.setText(map.get(randomBroj)[3]);
                    l.setText(map.get(randomBroj)[0]);
                    btn.setText("SledecePitanje");
                    btn.requestFocus();
                    btn1.setSelected(true);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Napravili ste gresku");
                a.setContentText("Pokusajte ponovo");
                a.show();
            }
        });

        exit.setOnAction(e -> {
            primaryStage.close();
        });

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) {
                RadioButton chk = (RadioButton) t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
                s = chk.getText();
                System.out.println(s);
            }
        });

        primaryStage.setTitle("QUIZ!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int randomNumber() {
        final int DUZINA_LISTE_BROJEVA = 4;
        int number = (int) (Math.random() * 4 + 1);

        if (sviBrojevi.contains(number) && sviBrojevi.size() < DUZINA_LISTE_BROJEVA) {
            return randomNumber();
        } else if (sviBrojevi.size() >= 4) {
            return 0;
        } else {
            sviBrojevi.add(number);
        }
        return number;
    }

}
