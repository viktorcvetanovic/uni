import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedBlockingQueue<>(Arrays.asList(3, 3, 3, 3, 2, 1, 8, 4, 5, 6, 7));
        System.out.println(Arrays.toString(searchQ(queue)));
        System.out.println(queue);
    }

    private static Integer[] searchQ(Queue<Integer> queue) {
        Queue<Integer> copyOfQueue = new LinkedBlockingQueue<>(queue);
        Integer max = queue.peek();
        int count = 1;
        while (!copyOfQueue.isEmpty()) {
            if (copyOfQueue.peek() > max) {
                count = 1;
                max = copyOfQueue.peek();
            } else if (copyOfQueue.peek().equals(max)) {
                count++;
            }
            copyOfQueue.poll();
        }
        removeDuplicates(queue);
        return new Integer[]{max, count};
    }

    private static void removeDuplicates(Queue<Integer> queue) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (!queue.isEmpty()) {
            if (!map.containsKey(queue.peek())) {
                map.put(queue.peek(), queue.peek());
            } else {
                queue.poll();
            }
        }
        queue.addAll(map.keySet());
    }
}
