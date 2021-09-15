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
public class PopTask implements Runnable {

    private MyStack stack;

    public synchronized void removeElement() {
        if (stack.getStack().size() > 0) {
            stack.pop();

        }
    }

    public MyStack getStack() {
        return stack;
    }

    public PopTask(MyStack stack) {
        this.stack = stack;
    }

    public void setStack(MyStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            removeElement();
        }

    }

}
