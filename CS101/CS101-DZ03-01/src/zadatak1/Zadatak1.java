/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double cena,mesec,plati;
        Scanner tastatura= new Scanner(System.in);
        System.out.println("Unesi cenu");
        cena=tastatura.nextDouble();
        System.out.println("Unesi meseci");
        mesec=tastatura.nextDouble();
        
        for(double i=1;i<mesec;i++){
            
            cena=cena+(cena/100*5);
            
        }
        if(cena>10000){
             System.out.println("Placate previse");
        }
        else{
             System.out.println("Trosite taman koliko treba");
        }
        
         System.out.println(cena);
         tastatura.close();
    }
    
}
