/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package2;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Oblik3D kvadar = new Kvadar(12, 12, 12);
        System.out.println(kvadar.racunajPovrsinu());
        System.out.println(kvadar.racunajZapreminu());
        Oblik3D lopta = new Lopta(3);
        System.out.println(lopta.racunajPovrsinu());
        System.out.println(lopta.racunajZapreminu());
    }

}
