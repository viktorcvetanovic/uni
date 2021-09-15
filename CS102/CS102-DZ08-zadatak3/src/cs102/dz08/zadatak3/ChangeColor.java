/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz08.zadatak3;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;

public class ChangeColor implements Runnable {

    @Override
    public void run() {
        while (true) {
            Main.rec.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChangeColor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
