/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        String[] niz = {"IDBroj", "Ime", "Prezime", "Godine", "Zvanje"};

        Set<Zaposleni> set = new TreeSet<>(new ZaposleniComparator());

        for (int i = 0; i < niz.length; i++) {
            vbox.getChildren().add(new Label(niz[i]));
            vbox.getChildren().add(new TextField());
        }
        root.setPadding(new Insets(10));
        root.setTop(vbox);
        Button btn = new Button("Dodaj Zaposlenog");
        root.setBottom(btn);
        BorderPane.setAlignment(btn, Pos.CENTER);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Dodaj zaposlenog");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction(e -> {
            List<String> lista = new ArrayList<>();
            for (Node node : vbox.getChildren()) {
                if (node instanceof TextField) {
                    lista.add(((TextField) node).getText());
                }
            }
            try {
                Long.valueOf(lista.get(0));
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("GRESKA");
                alert.setHeaderText("POGRESAN UNOS");
                alert.show();
            }
            if (set.add(new Zaposleni(Long.valueOf(lista.get(0)), lista.get(1), lista.get(2), Integer.valueOf(lista.get(3)), lista.get(4)))) {
                set.add(new Zaposleni(Long.valueOf(lista.get(0)), lista.get(1), lista.get(2), Integer.valueOf(lista.get(3)), lista.get(4)));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("USPESNO STE DODALI");
                alert.setHeaderText("USPESNO STE DODALI");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("GRESKA");
                alert.setHeaderText("GRESKA VEC POSTOJI TAJ CLAN");
                alert.show();
            }
            System.out.println(set);

            for (Node node : vbox.getChildren()) {
                if (node instanceof TextField) {
                    ((TextField) node).setText("");
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
