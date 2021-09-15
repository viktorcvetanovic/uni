/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v04.zadatak1;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 *
 * @author vikto
 */
public class CS102V04Zadatak1 extends Application {

    Media media = new Media("http://techslides.com/demos/sample-videos/small.mp4");
    MediaPlayer mp = new MediaPlayer(media);
    MediaView mw = new MediaView(mp);

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        ObservableList<Video> videos = FXCollections.observableArrayList(
                new Video("auto", "http://techslides.com/demos/sample-videos/small.mp4"), new Video("zec", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"), new Video("film", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
        ListView<Video> lw = new ListView<Video>(videos);
        vbox.getChildren().add(lw);
        vbox.setMaxWidth(100);

        root.setRight(vbox);

        lw.getSelectionModel().selectedItemProperty().addListener(e -> {
            Video video = lw.getSelectionModel().getSelectedItem();
            System.out.println(video.getURL());
            media = new Media(video.getURL());
            mp = new MediaPlayer(media);
            mw = new MediaView(mp);
            mw.setFitWidth(450);
            root.setCenter(mw);
            mp.play();
        });

        HBox hbox = new HBox();
        Button play = new Button("Play");
        Button pause = new Button("Pause");
        Button stop = new Button("Stop");
        Slider s = new Slider(0, 1, 0);
        hbox.getChildren().addAll(play, pause, stop, s);
        hbox.setAlignment(Pos.CENTER);
        root.setBottom(hbox);
        Scene scene = new Scene(root, 800, 500);

        s.valueProperty().addListener(e -> {
            mp.setVolume(s.getValue());
        });

        play.setOnAction(e -> {
            mp.play();
        });

        stop.setOnAction(e -> {
            mp.stop();
        });

        pause.setOnAction(e -> {
            mp.pause();
        });
        primaryStage.setTitle("Video Player");
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
