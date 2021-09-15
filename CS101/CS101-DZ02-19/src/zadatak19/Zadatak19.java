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
        int broj,broj2;
      
        Scanner tastatura= new Scanner(System.in);
        System.out.println("Unesite celi trocifreni  broj: ");
        broj=tastatura.nextInt();
        broj2= broj;
        int count = 0;

        while(broj2!= 0)
        {
            // num = num/10
            broj2 /= 10;
            ++count;
        }
        
            if( count==3){
            broj=broj/100+broj/10%10+broj%10;
            System.out.println("Zbir cifara vaseg broja je "+broj);
        }
        else{
            System.out.println("Vas broj nije trocifreni broj");
        }
    }
    
    
}
