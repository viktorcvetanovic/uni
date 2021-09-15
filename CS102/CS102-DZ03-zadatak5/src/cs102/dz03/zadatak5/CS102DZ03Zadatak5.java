/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz03.zadatak5;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102DZ03Zadatak5 extends Application {

    private File selectedFile;
    private Media media;
    private MediaPlayer player;
    private MediaView mediaView;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new ExtensionFilter("Video files", "*.mp4"), new ExtensionFilter("Audio Files", "*.mp3"));
        Button button = new Button("Dodaj fajl");
        root.setTop(button);
        HBox box = new HBox();
        Button stop = new Button("Stop");
        Button pause = new Button("Pause");
        Button play = new Button("Play");
        box.getChildren().addAll(stop, pause, play);
        root.setBottom(box);
        button.setAlignment(Pos.CENTER);
        box.setAlignment(Pos.CENTER);

        button.setOnAction(e -> {
            selectedFile = fc.showOpenDialog(primaryStage);
            playMusic();
        });

        play.setOnAction(e -> {
            player.play();
        });

        stop.setOnAction(e -> {
            player.stop();
        });

        pause.setOnAction(e -> {
            player.pause();
        });

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Music/Video Player");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void playMusic() {
        media = new Media(selectedFile.toURI().toString());
        player = new MediaPlayer(media);
        mediaView = new MediaView(player);
        Pane pane = new Pane(mediaView);
        root.setCenter(pane);
    }
}
