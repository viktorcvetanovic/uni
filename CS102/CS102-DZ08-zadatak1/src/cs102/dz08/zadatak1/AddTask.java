/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz08.zadatak1;

/**
 *
 * @author vikto
 */
public class AddTask implements Runnable {

    private MyStack stack;

    public MyStack getStack() {
        return stack;
    }

    public void setStack(MyStack stack) {
        this.stack = stack;
    }

    public synchronized <T> void addElement(T x) {
        stack.push(x);
    }

    @Override
    public void run() {
        while (true) {
            addElement(5);

        }
    }

    public AddTask(MyStack stack) {
        this.stack = stack;
    }

}
