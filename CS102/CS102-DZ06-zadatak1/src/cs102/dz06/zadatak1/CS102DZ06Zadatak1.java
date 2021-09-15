/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz06.zadatak1;

import java.util.Stack;

/**
 *
 * @author vikto
 */
public class CS102DZ06Zadatak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Integer> A = new Stack<>();
        for (int i = 1; i < 11; i++) {
            A.push(i);
        }
        dodaj_na_pocetak(A, 0);
        System.out.println(A);
    }

    public static void dodaj_na_pocetak(Stack<Integer> A, int broj) {
        Stack<Integer> B = new Stack<>();

        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        B.push(broj);

        while (!B.isEmpty()) {
            A.push(B.pop());
        }
    }
}
