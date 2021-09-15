/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package7;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alati elektricni = new ElektricniAlati(200, 120, "Bosh", "0123", 200);
        System.out.println(elektricni);
        Alati mehanicki = new MehanickiAlati("20", "Gorenje", "123", 1500);
        System.out.println(mehanicki);
        Alati rucni = new RucniAlati(12, "ASFSA", "123", 1100);
        System.out.println(rucni);
    }

}
