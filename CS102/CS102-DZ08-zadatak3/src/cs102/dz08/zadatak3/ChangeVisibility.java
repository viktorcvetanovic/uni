/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz08.zadatak3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikto
 */
public class ChangeVisibility implements Runnable {

    private static boolean visible = false;

    @Override
    public void run() {
        while (true) {
            visible = !visible;
            Main.rec.setVisible(visible);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChangeVisibility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
