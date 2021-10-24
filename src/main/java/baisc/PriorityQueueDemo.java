package baisc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author casyd_xue
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q1 = new PriorityQueue<>(Comparator.naturalOrder());
        q1.offer(10);
        q1.offer(3);
        q1.offer(2);
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println(q1.poll());
        System.out.println("============");
        Queue<Integer> q2 = new PriorityQueue<>(Comparator.reverseOrder());
        q2.offer(10);
        q2.offer(3);
        q2.offer(2);
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println("============");
        Queue<int[]> q3 = new PriorityQueue<>(Comparator.comparingInt(interval -> interval[0]));

        q3.offer(new int[]{1, 2});
        q3.offer(new int[]{2, 3});
        q3.offer(new int[]{4, 3});
        q3.offer(new int[]{3, 3});

        System.out.println(Arrays.toString(q3.poll()));
        System.out.println(Arrays.toString(q3.poll()));
        System.out.println(Arrays.toString(q3.poll()));
        System.out.println(Arrays.toString(q3.poll()));
    }
}
