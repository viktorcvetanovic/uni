/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.pesma.Pesma;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class FileWrite {

    public static void upisiUFajl(List<Pesma> lista) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("podaci.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Pesma s : lista) {
            pw.print(s.upisZaFajl());
        }
        pw.close();
        pw.flush();

    }
}
