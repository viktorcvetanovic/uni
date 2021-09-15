/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak2;

/**
 *
 * @author vikto
 */
public class Zadatak2 {

    public static int zbir(int n, int m) {
        int zbir = 0;
        if (n < m) {
            for (int i = n; i <= m; i++) {
                zbir += i;
            }
            return zbir;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(zbir(5, 5));
    }

}
