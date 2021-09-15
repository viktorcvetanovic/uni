/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s1 = new Student("Viktor", "Cvetanovic", 4421, 10.0);
        Student s2 = new Student("Viktor", "Cvetanovic", 4421, 9.0);
        Student s3 = new Student("Viktor", "Cvetanovic", 4421, 7.0);
        Student s4 = new Student("Viktor", "Cvetanovic", 4421, 8.0);
        Student s5 = new Student("Viktor", "Cvetanovic", 4421, 6.0);
        Student s6 = new Student("Viktor", "Cvetanovic", 4421, 5.0);
        Student s7 = new Student("Viktor", "Cvetanovic", 4421, 4.0);
        Student s8 = new Student("Viktor", "Cvetanovic", 4421, 2.0);
        
        List<Student> lista = new ArrayList<>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8));
        System.out.println(najveciProsek(lista));
    }
    
    public static Student najveciProsek(List<Student> lista) {
        double prosek = Integer.MIN_VALUE;
        Student max = new Student();
        for (Student s : lista) {
            if (s.getProsek() > prosek) {
                prosek = s.getProsek();
                max = s;
            }
        }
        return max;
    }
}
