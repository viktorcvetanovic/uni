package cs102.dz07;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Payment extends Application {

    double stanjeRacuna = 0;

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();

        Label accountNumberLabel = new Label("Account Number: ");
        Label sumLabel = new Label("Enter sum: ");

        TextField sumTextField = new TextField();
        TextField accountNumberTextField = new TextField();

        Button buttonPayout = new Button("Uplata");

        Button buttonStanje = new Button("Stanje");

        Button buttonExit = new Button("Exit");

        Button buttonShow = new Button("Prikazi");

        Button buttonBack = new Button("Back");

        buttonExit.setOnMouseClicked(e -> {
            primaryStage.close();
        });

        buttonBack.setOnAction(e -> {
            new Main().start(primaryStage);
        });

        HBox hBoxButton = new HBox();
        hBoxButton.getChildren().addAll(buttonPayout, buttonStanje, buttonExit, buttonShow, buttonBack);
        hBoxButton.setSpacing(10);

        buttonPayout.setOnMouseClicked(e -> {
            if (proveriRacun(accountNumberTextField.getText()) == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "NE POSTOJI OVAKAV RACUN");
                alert.show();
                return;
            }
            try {
                stanjeRacuna = Double.valueOf(sumTextField.getText());
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Morate uneti vrednost uplate");
                alert.show();
            }

            if (Database.map.get(accountNumberTextField.getText()) != null) {
                Database.map.put(accountNumberTextField.getText(), Database.map.get(accountNumberTextField.getText()) + stanjeRacuna);
            } else {
                Database.map.put(accountNumberTextField.getText(), stanjeRacuna);
            }
            System.out.println(Database.map);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Racun je uspesno dopunjen.");
            alert.show();
        });

        buttonStanje.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Stanje racuna je: " + Database.map.get(accountNumberTextField.getText()));
            alert.show();
        });

        buttonShow.setOnMouseClicked(e -> {
            Racun r = proveriRacun(accountNumberTextField.getText());
            if (r == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "NE POSTOJI OVAKAV RACUN ");
                alert.show();
            } else {
                System.out.println(r.toString());
            }

        });

        root.add(accountNumberLabel, 0, 0);
        root.add(accountNumberTextField, 1, 0);
        root.add(sumLabel, 0, 1);
        root.add(sumTextField, 1, 1);
        root.add(hBoxButton, 1, 2);
        root.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Payout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Racun proveriRacun(String racun) {
        Racun rac = null;
        for (Racun r : Main.set) {
            if (r.getAccountNumber().equals(racun)) {
                rac = r;
            }
        }
        return rac;
    }

}
