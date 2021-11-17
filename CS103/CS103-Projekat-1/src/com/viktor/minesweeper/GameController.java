package com.viktor.minesweeper;

import com.viktor.minesweeper.alerts.CustomAlert;
import com.viktor.minesweeper.data.Block;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static com.viktor.minesweeper.config.Config.*;

public class GameController {
    private List<Block> blockList = new ArrayList<>();
    private List<Block> bombList = new ArrayList<>();
    private int placedBombs = 0;
    private Stage primaryStage;
    GraphicsContext gc;
    private static final int ARRAY[][] = new int[][]{{1, 0}, {0, 1}, {1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}};


    public GameController(GraphicsContext gc, Stage primaryStage) {
        this.gc = gc;
        this.primaryStage = primaryStage;
    }

    public void handleClick(MouseEvent event) {
        int x = (int) event.getX() / SQUARE_SIZE;
        int y = (int) event.getY() / SQUARE_SIZE;
        Block block = findByCoordinates(x, y);
// hack       renderBombs(block);
        if (event.isPrimaryButtonDown()) {

            if (block.isFlag()) {
                return;
            }
            if (block.isBomb()) {
                loseGame(block);
            }
            openBlocks(block);
            winGame();
        } else {
            openFlag(block);
        }
    }

    private void openBlocks(Block block) {
        if (block.isOpen()) {
            return;
        }
        block.setOpen(true);
        renderBlock(block);
        int bombNearby=bombNearby(block);
        if (bombNearby>0) {
            block.setNumber(bombNearby);
            renderBlock(block);
            return;
        }


        for (int[] arr : ARRAY) {
            Block nextBlock = findByCoordinates(block.getX() + arr[0], block.getY() + arr[1]);
            if (nextBlock != null) {
                block.setNumber(0);
                openBlocks(nextBlock);
            }
        }

    }


    private void renderBlock(Block block) {
        if ((block.getX() + block.getY()) % 2 == 0) {
            gc.setFill(Color.ANTIQUEWHITE);
        } else {
            gc.setFill(Color.WHITESMOKE);
        }
        gc.fillRect(block.getX() * SQUARE_SIZE, block.getY() * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
        if (block.getNumber() != null) {
            gc.setFill(Color.BLACK);
            gc.setFont(new Font("Verdana", 20));
            gc.setTextAlign(TextAlignment.CENTER);
            gc.fillText(String.valueOf(block.getNumber()), block.getX() * SQUARE_SIZE+SQUARE_SIZE/2, block.getY() * SQUARE_SIZE+SQUARE_SIZE/2);
        }

    }

    private int bombNearby(Block block) {
        int count=0;
        for (Block bomb : bombList) {
            int x = bomb.getX() - block.getX();
            boolean isX = x >= -1 && x <= 1;
            int y = bomb.getY() - block.getY();
            boolean isY = y >= -1 && y <= 1;
            if (isX && isY) {
                count++;
            }
        }
        return count;
    }

    private void loseGame(Block block) {
        renderBombs(block);
        Alert alert = CustomAlert.createCustomAlert("Kraj igre", "Izgubili ste");
        endGame(alert);
    }

    private void endGame(Alert alert){
        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent() || result.get() == ButtonType.OK) {
            new Main().start(primaryStage);
        }
    }

    private void winGame(){
        boolean win=true;
        for(Block block:blockList){
            if(!block.isBomb() && !block.isOpen()){
                win=false;
            }
        }
        if(win){
            Alert alert = CustomAlert.createCustomAlert("Kraj igre", "Pobedili ste ste");
            endGame(alert);
        }
    }




    private void placeRandomBomb(Block block) {
        int randomNum = new Random().nextInt((11 - 1) + 1) + 1;
        if (placedBombs < bombSize) {
            if (randomNum < 3) {
                block.setBomb(true);
                placedBombs++;
                bombList.add(block);
            }
        }
    }

    private void renderBombs(Block bl) {
        for (Block block : bombList) {
            gc.setFill(Color.BLACK);
            gc.drawImage(new Image("assets/bomb.png"), block.getX() * SQUARE_SIZE, block.getY() * SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
        }
        gc.setFill(Color.RED);
        gc.fillRect(bl.getX() * SQUARE_SIZE, bl.getY() * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
        gc.drawImage(new Image("assets/bomb.png"), bl.getX() * SQUARE_SIZE, bl.getY() * SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
    }

    public void openFlag(Block block) {
        if (block.isOpen()) {
            return;
        }
        renderFlag(block);
    }

    private void renderFlag(Block block) {
        Image image = new Image("assets/flag.png");
        if (!block.isFlag()) {
            block.setFlag(true);
            gc.drawImage(image, block.getX() * SQUARE_SIZE, block.getY() * SQUARE_SIZE, SQUARE_SIZE - 1, SQUARE_SIZE - 1);
            return;
        }
        block.setFlag(false);
        if ((block.getX() + block.getY()) % 2 == 0) {
            gc.setFill(Color.LIMEGREEN);
        } else {
            gc.setFill(Color.GREENYELLOW);
        }
        gc.fillRect(block.getX() * SQUARE_SIZE, block.getY() * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
    }


    public void drawCanvas() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.LIMEGREEN);
                } else {
                    gc.setFill(Color.GREENYELLOW);
                }
                gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
                Block block = Block.forStart(i, j);
                placeRandomBomb(block);
                blockList.add(block);
            }
        }

    }

    private Block findByCoordinates(int x, int y) {
        for (Block block : blockList) {
            if (block.getX() == x && block.getY() == y) {
                return block;
            }
        }
        return null;
    }

}
