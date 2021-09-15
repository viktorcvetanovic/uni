/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak1;

import static java.lang.Math.sqrt;
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
        float a,b,c,kvadrat;
        Scanner tastatura= new Scanner(System.in);
        System.out.println("Unesite a: ");
        a=(float) tastatura.nextDouble();
        System.out.println("Unesite b: ");
        b=(float) tastatura.nextDouble();
        
        kvadrat=a*a+b*b;
        c=(float) sqrt(kvadrat);
        System.out.println("Stranica c je: "+c);
    }
    
}
