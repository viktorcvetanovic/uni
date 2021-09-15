package zadatak3;

import java.util.Stack;

public class Zadatak3 {

    public static void main(String[] args) {
        Stack stack = new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(zameniStack(stack, 2, 125));
    }

    public static Stack<Integer> zameniStack(Stack stack, int poz, int el) {
        System.out.println(stack);
        Stack B = new Stack<Integer>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            B.push(stack.pop());
        }
        for (int i = 0; i < size; i++) {
            if (i == poz) {
                stack.push(el);
            } else {
                stack.push(B.pop());
            }
        }
        return stack;
    }

}
