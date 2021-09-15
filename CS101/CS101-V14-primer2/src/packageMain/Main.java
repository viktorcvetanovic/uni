/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
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
        final String DIR = "studenti.txt";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(DIR);
            pw.println("Marko~Markovic~1234~10~10~9");
            pw.println("Marija~Markovic~1235~10~10~9~8~7");
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } finally {
            pw.close();
        }
        
        try {
            Scanner get = new Scanner(new File(DIR));
            Student s1 = new Student();
            String tekst = get.next();
            String[] tekstNiz = new String[4];
            tekstNiz = tekst.split("~");
            s1.setIme(tekstNiz[0]);
            System.out.print(s1);
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        }
        
    }
    
}
