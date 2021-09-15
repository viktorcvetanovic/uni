/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikto
 */
public class Main {

    public static void upisiTekst(String tekst, String putanja) throws IOException {
        PrintWriter fw = new PrintWriter(putanja);
        fw.print(tekst);
        fw.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("Unesite putanju");
        String putanja = input.nextLine();

        Scanner get = new Scanner(new File(putanja));

        try {
            String tekst = "";

            while (get.hasNext()) {
                String proveriRec = get.nextLine();
                tekst += proveriRec;
            }

            tekst = tekst.replaceAll("programiranje", "zabava");
            upisiTekst(tekst, putanja);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
