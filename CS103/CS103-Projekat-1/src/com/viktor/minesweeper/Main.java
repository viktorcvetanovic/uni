package com.viktor.minesweeper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.viktor.minesweeper.config.Config.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, WIDTH-SQUARE_SIZE/4, HEIGHT-SQUARE_SIZE/4);
        primaryStage.setTitle("Minesweeper");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.getIcons().add(new Image("assets/flag.png"));
        GameController gameController = new GameController(gc,primaryStage);
        gameController.drawCanvas();
        scene.setOnMousePressed(gameController::handleClick);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
