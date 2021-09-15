package cs102.dz07;

import java.util.Set;
import java.util.TreeSet;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static Set<Racun> set = new TreeSet<>(new RacunComparator());

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        Label nameLabel = new Label("Name: ");
        Label accountNumberLabel = new Label("Account Number: ");

        TextField nameTextField = new TextField();
        TextField accountNumberTextField = new TextField();

        Button buttonAdd = new Button("Add");

        buttonAdd.setOnMouseClicked(e -> {
            Racun racun = new Racun(nameTextField.getText(), accountNumberTextField.getText());

            if (set.add(racun)) {
                set.add(racun);
                System.out.println(set);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Racun je uspesno kreiran.");
                alert.show();
            } else {
                System.out.println(set);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Taj korisnik vec postoji.");
                alert.show();
            }

        });

        Button buttonPayout = new Button("Payout");

        buttonPayout.setOnMouseClicked(e -> {
            primaryStage.close();
            Payment paymant = new Payment();
            paymant.start(primaryStage);

        });

        Button buttonExit = new Button("Exit");

        buttonExit.setOnMouseClicked(e -> {
            primaryStage.close();

        });

        HBox hBoxButton = new HBox();
        hBoxButton.getChildren().addAll(buttonAdd, buttonPayout, buttonExit);
        hBoxButton.setSpacing(10);

        root.add(nameLabel, 0, 0);
        root.add(nameTextField, 1, 0);
        root.add(accountNumberLabel, 0, 1);
        root.add(accountNumberTextField, 1, 1);
        root.add(hBoxButton, 1, 2);
        root.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Create account");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
