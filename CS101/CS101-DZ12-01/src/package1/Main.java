/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author vikto
 */
public class Main {

    public static Student najveciProsek(List<Student> list) {
        double prosek = Integer.MIN_VALUE;
        Student max = new Student();
        for (Student s : list) {
            if (s.getProsek() > prosek) {
                prosek = s.getProsek();
                max = s;

            }
        }
        return max;

    }

    public static void main(String[] args) {
        Student s1 = new Student("Viktor", "Cvetanovic", 10, 4421);
        Student s2 = new Student("MIlena", "Cvetanovic", 9.7, 4251);
        Student s3 = new Student("Zoran", "Cvetanovic", 8, 4214);
        Student s4 = new Student("Petar", "Cvetanovic", 6, 5125);
        System.out.println(najveciProsek(Arrays.asList(s1, s2, s3, s4)));
    }

}
