/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak3;

import java.util.Set;
import java.util.TreeSet;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private static Set<Student> set;

    @Override
    public void start(Stage primaryStage) {
        Integer vrednost;
        set = new TreeSet(new ComparatorByIndex());
        BorderPane root = new BorderPane();
        Button btn = new Button();
        Label l = new Label("Unesi ime");
        TextField tf = new TextField();
        Label l2 = new Label("Unesi prezime");
        TextField tf2 = new TextField();
        Label l3 = new Label("Unesi indeks");
        TextField tf3 = new TextField();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton1 = new RadioButton("Sortiraj po imenu");
        RadioButton radioButton2 = new RadioButton("Sortiraj po prezimenu");
        RadioButton radioButton3 = new RadioButton("Sortiraj po indeksu");
        radioButton3.setSelected(true);
        radioButton1.setUserData(1);
        radioButton2.setUserData(2);
        radioButton3.setUserData(3);
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        VBox hbox = new VBox(l, tf, l2, tf2, l3, tf3, radioButton1, radioButton2, radioButton3);
        btn.setText("Dodaj studenta");

        root.setTop(hbox);
        root.setBottom(btn);
        root.setPadding(new Insets(10));
        BorderPane.setAlignment(btn, Pos.CENTER);

        Scene scene = new Scene(root, 300, 250);
        toggleGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            proveriSort((Integer) newVal.getUserData());
        });
        btn.setOnAction(e -> {
            try {
                Integer.valueOf(tf3.getText());
            } catch (Exception ex) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("POGRESN UNOS");
                al.setHeaderText("POGRESN UNOS");
                al.show();
            }
            if (set.add(new Student(tf.getText(), tf2.getText(), Integer.valueOf(tf3.getText())))) {
                set.add(new Student(tf.getText(), tf2.getText(), Integer.valueOf(tf3.getText())));
                System.out.println(set);
            } else {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("TAJ KORISNIK VEC POSTOJI");
                al.setHeaderText("TAJ KORISNIK VEC POSTOJI");
                al.show();
            }
        });
        primaryStage.setTitle("Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void proveriSort(Integer userData) {
        Set<Student> helpSet = set;
        if (userData.equals(3)) {
            set = new TreeSet(new ComparatorByIndex());
        } else if (userData.equals(1)) {
            set = new TreeSet(new ComparatorByName());
        } else {
            set = new TreeSet(new ComparatorBySurname());
        }
        set.addAll(helpSet);
        System.out.println(set);
    }

}
