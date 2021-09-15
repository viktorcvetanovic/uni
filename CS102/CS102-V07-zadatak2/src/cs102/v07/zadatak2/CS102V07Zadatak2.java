/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v07.zadatak2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author vikto
 */
public class CS102V07Zadatak2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Pitanje> stack = new Stack<>();
        initStack(stack);
        Scanner in = new Scanner(System.in);
        while (!stack.isEmpty()) {
            Pitanje pitanje = stack.pop();
            System.out.println(pitanje.getPitanje());
            String a = in.nextLine();
            if (!a.equals(pitanje.getOdgovor())) {
                System.out.println("Greska");
                break;
            }
        }
    }

    public static void initStack(Stack<Pitanje> stack) {
        stack.push(new Pitanje("2+2", "4"));
        stack.push(new Pitanje("5+5", "10"));
        stack.push(new Pitanje("3+3", "6"));
    }

}
