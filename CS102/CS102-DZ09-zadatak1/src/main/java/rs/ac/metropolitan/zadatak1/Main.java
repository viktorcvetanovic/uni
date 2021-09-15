package rs.ac.metropolitan.zadatak1;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import rs.ac.metropolitan.zadatak1.data.Observer;
import rs.ac.metropolitan.zadatak1.data.ProgressBarObserver;
import rs.ac.metropolitan.zadatak1.data.ProgressBarSubject;
import rs.ac.metropolitan.zadatak1.threads.InformationGatheringThread;

import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private BorderPane root;
    public static ProgressBar pb;
    public static ProgressIndicator pi;
    public static ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        ObservableList<String> list = listView.getItems();

        root = new BorderPane();
        createProgressBar(0.0);
        List<Observer<Integer[]>> observers = Arrays.asList(new ProgressBarObserver(pb), new ProgressBarObserver(pi));
        ProgressBarSubject observer = new ProgressBarSubject(observers);

        Scene scene = new Scene(root);
        new Thread(new InformationGatheringThread(observer, list)).start();
        root.setTop(listView);
        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Polovni Automobili");
        primaryStage.show();
    }

    private void createProgressBar(Double progress) {
        if (!(progress <= 0) && !(progress >= 1)) {
            progress = 0.0;
        }
        HBox hbox = new HBox();
        pb = new ProgressBar(progress);
        pi = new ProgressIndicator(progress);
        hbox.getChildren().addAll(pb, pi);
        hbox.setSpacing(10);
        BorderPane.setAlignment(hbox, Pos.CENTER);
        root.setCenter(hbox);
    }
}
