/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import exceptions.EmptyFieldException;
import exceptions.IndexInputException;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Student s = new Student("viktor", "Cvetanovic", "123");
            System.out.println("Napravili ste studenta");
        } catch (EmptyFieldException ex) {
            System.out.println(ex.getMessage());
        } catch (IndexInputException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
