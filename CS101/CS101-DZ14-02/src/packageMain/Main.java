/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("zadatak2.txt");
        try {
            PrintWriter p = new PrintWriter(f);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
