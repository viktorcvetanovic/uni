package com.viktor.minesweeper.alerts;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomAlert {

    public static Alert createCustomAlert(String headerText, String bodyText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(headerText);
        alert.setHeaderText(headerText);
        ImageView icon = new ImageView("/assets/flag.png");
        icon.setFitHeight(48);
        icon.setFitWidth(48);
        alert.getDialogPane().setGraphic(icon);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/assets/flag.png"));
        alert.setContentText(bodyText);
        return alert;
    }
}
