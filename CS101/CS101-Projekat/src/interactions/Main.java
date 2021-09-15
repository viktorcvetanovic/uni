/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interactions;

import static gui.WelcomeGUI.menuOne;
import static gui.WelcomeGUI.menuThree;
import static gui.WelcomeGUI.menuTwo;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * main metoda
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                menuOne();
                System.out.println();
                System.out.println("Ako zelite da pogleda ponudu napisite 1");
                System.out.println("Ako zelite da napravite svoj auto napisite 2");
                int unos = sc.nextInt();
                if (unos == 1) {
                    menuThree();
                    break;
                } else if (unos == 2) {
                    menuTwo();
                    break;
                } else {
                    System.err.println("Pogresan broj se uneli.Pokusajte opet");
                }

            } catch (IllegalArgumentException ex) {
                System.err.println("Pogresan podatak ste uneli");
            } catch (InputMismatchException ex) {
                System.err.println("Nevalidan tip podatka ste uneli");
            }
        }
    }

}
