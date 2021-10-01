package baisc;

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
    }
}
