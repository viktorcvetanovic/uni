/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz08.zadatak1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author vikto
 */
public class CS102DZ08Zadatak1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        Thread thread = new Thread(new AddTask(stack));
        Thread thread2 = new Thread(new PopTask(stack));
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(thread);
        executor.execute(thread2);
    }

}
