/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz08.zadatak1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikto
 */
public class MyStack<E> {

    private List<E> stack = new ArrayList<>();

    public MyStack() {
    }

    public List<E> getStack() {
        return stack;
    }

    public void setStack(List<E> stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        return "MyStack{" + "stack=" + stack + '}';
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public <T> void push(T x) {
        stack.add((E) x);
    }
}
