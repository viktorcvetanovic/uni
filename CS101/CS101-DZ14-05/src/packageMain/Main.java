/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikto
 */
public class Main {

    public static void sacuvajBrojac(int brojac) {
        try {
            PrintWriter p = new PrintWriter("zadatak.txt");
            p.println(brojac);
            p.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int procitajBrojac() throws IOException {
        int brojac = 0;
        StringBuilder content = new StringBuilder();
        String line;
        try {
            BufferedReader r = new BufferedReader(new FileReader("zadatak.txt"));
            while ((line = r.readLine()) != null) {
                content.append(line);
            }
            brojac = Integer.parseInt(content.toString());

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return brojac;
    }

    public static void main(String[] args) {

        try {
            int brojac = procitajBrojac();
            brojac++;
            sacuvajBrojac(brojac);
            System.out.println("Ovo je " + brojac + "-to pokretanje programa");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
