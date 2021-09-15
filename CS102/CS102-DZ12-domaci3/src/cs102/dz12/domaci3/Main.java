/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz12.domaci3;

public class Main {

    public static void main(String[] args) {
        System.out.println(parniBrojevi(222));
    }

    public static Integer parniBrojevi(Integer broj) {
        int sum = 0;
        if (broj == null) {
            throw new NullPointerException();
        }
        if (broj < 0) {
            System.out.println("Pretvorili smo broj u pozitivnu vrednost");
            broj = Math.abs(broj);
        }
        if ((broj % 10) % 2 == 0) {
            sum++;
        }
        if (broj == 0) {
            return 0;
        }

        return sum + parniBrojevi(broj / 10);
    }

}
