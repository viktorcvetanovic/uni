/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs101.vezba;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author vikto
 */
public class CS101Vezba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  

    

    public static List<Integer> procitajSprave() throws FileNotFoundException, IOException {
        List<Integer> sprave = new ArrayList<>();
        try {

            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Sasa\\Documents\\NetBeansProjects\\CS101-PZ"));
            String line = null;
            while ((line = bf.readLine()) != null) {
                String niz[] = new String[3];
                niz = line.split(",");
                Integer s = new Sprava(niz[0], Double.parseDouble(niz[1]), Double.parseDouble(niz[2]));
                sprave.add(s);
            }

        } catch (IOException ex) {

        }
        return sprave;
    }
}

}
