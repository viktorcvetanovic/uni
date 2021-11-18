import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(1, 3, 5, 76, 9, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(stack);
        insertSecond(42, stack);
        System.out.println(stack);
    }

    public static <T> void insertSecond(T x, Stack<T> s) {
        Stack<T> helpStack = new Stack<>();
        int len = s.size();
        for (int i = 0; i < len; i++) {
            if (i == len - 2) {
                helpStack.push(x);
                s.pop();
                continue;
            }
            helpStack.push(s.pop());
        }
        for (int i = 0; i < len; i++) {
            s.push(helpStack.pop());
        }
    }

}
