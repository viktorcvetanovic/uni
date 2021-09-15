/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageMain;

import classes.Student;
import exceptions.ImeNijeValidnoException;
import exceptions.IndeksNijeValidanException;
import exceptions.StudentException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Student s1 = new Student("Viktor", "Cvetanovic", "Somborska", "nis", "1234");
        } catch (StudentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
