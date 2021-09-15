/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz01.zadatak5;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ01Zadatak5 extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextArea tx = new TextArea();

        Label head = new Label("Employee Records Editor");

        GridPane panel = new GridPane();

        Label employee = new Label("Emplooye ID: ");
        TextField emInput = new TextField();
        emInput.setPrefWidth(50);
        Label fullName = new Label("Full Name:");

        TextField nameInput = new TextField();

        Label gender = new Label("Gender:");
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "Male",
                        "Female",
                        "Other"
                );
        ComboBox comboBox = new ComboBox(options);

        Label dep = new Label("Department:");
        TextField depInput = new TextField();
        depInput.setPrefWidth(100);

        Label pos = new Label("Position:");
        TextField posInput = new TextField();
        posInput.setPrefWidth(100);

        Label sal = new Label("Salary:");
        TextField salInput = new TextField();
        salInput.setPrefWidth(100);

        panel.setVgap(5);

        GridPane paneForGender = new GridPane();
        paneForGender.add(gender, 0, 0);
        paneForGender.add(comboBox, 1, 0);
        paneForGender.add(dep, 2, 0);
        paneForGender.add(depInput, 3, 0);
        paneForGender.setHgap(25);

        GridPane paneForEmployee = new GridPane();
        paneForEmployee.add(employee, 0, 0);
        paneForEmployee.add(emInput, 1, 0);

        GridPane paneForName = new GridPane();
        paneForName.add(fullName, 0, 1);
        paneForName.add(nameInput, 1, 1);

        GridPane paneForPosition = new GridPane();
        paneForPosition.add(pos, 0, 0);
        paneForPosition.add(posInput, 1, 0);
        paneForPosition.add(sal, 2, 0);
        paneForPosition.add(salInput, 3, 0);
        paneForPosition.setHgap(25);

        GridPane paneForButtons = new GridPane();
        Button btn = new Button("Add new");
        Button btn2 = new Button("Update");
        Button btn3 = new Button("Delete");
        Button btn4 = new Button("Print all");
        Button btn5 = new Button("Close");
        paneForButtons.add(btn, 0, 0);
        paneForButtons.add(btn2, 1, 0);
        paneForButtons.add(btn3, 2, 0);
        paneForButtons.add(btn4, 3, 0);
        paneForButtons.add(btn5, 4, 0);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setHgap(10);
        panel.add(paneForEmployee, 0, 0);
        panel.add(paneForName, 0, 1);
        panel.add(paneForGender, 0, 2);
        panel.add(paneForPosition, 0, 3);
        panel.setStyle("-fx-border-color: grey;-fx-padding:10");
        GridPane root = new GridPane();
        root.add(tx, 0, 0);
        root.add(head, 0, 1);
        root.add(panel, 0, 2);
        root.add(paneForButtons, 0, 3);
        root.setVgap(5);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Design Preview");
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
