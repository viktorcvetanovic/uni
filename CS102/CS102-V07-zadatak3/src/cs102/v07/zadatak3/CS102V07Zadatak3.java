/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.v07.zadatak3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vikto
 */
public class CS102V07Zadatak3 {

    private static Stack<Pitanje> stack;
    private static Scanner in = new Scanner(System.in);
    private static long startTime;
    private static long estimatedTime;
    private static String name;

    public static void main(String[] args) {
        stack = new Stack<>();
        initStack(stack);

        System.out.println("Unesi svoje ime: ");
        name = in.nextLine();
        run();
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(estimatedTime));
        writeToFile();
    }

    public static void initStack(Stack<Pitanje> stack) {
        stack.push(new Pitanje("2+2", "4"));
        stack.push(new Pitanje("5+5", "10"));
        stack.push(new Pitanje("3+3", "6"));
    }

    public static void run() {
        System.out.println("POCELO JE ODBROJAVANJE");
        startTime = System.currentTimeMillis();
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

    public static void writeToFile() {
        try {
            PrintWriter pw = new PrintWriter(new File("data.txt"));
            pw.println(name + " " + String.valueOf(TimeUnit.MILLISECONDS.toSeconds(estimatedTime)));
            pw.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CS102V07Zadatak3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
