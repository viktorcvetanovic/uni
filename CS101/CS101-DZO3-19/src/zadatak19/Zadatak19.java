/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak19;

import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Zadatak19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double broj;
        System.out.println("Unesi neki broj: ");
        Scanner tastatura=new Scanner(System.in);
        broj=tastatura.nextDouble();
        if (broj%2==0){
            broj=broj/3.0;
            double broj2= (double)Math.round(broj* 1000d) / 1000d;
            System.out.println("Broj  je paran");
            System.out.println(broj2);
        }
        else {
            broj=broj/5.0;
            double broj2= (double)Math.round(broj* 1000d) / 1000d;
            System.out.println("Broj nije paran ");
            System.out.println(broj2);
            
            
        }
        tastatura.close();
    }
    
}
