package shein20231026;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * User: caserwin
 * Date: 2023/10/30 08:27
 * Description:
 */
public class Main {
    public static void main(String[] args){
        Queue<Integer> queue = new ArrayDeque<>();

        int a = 1;
        // 入队列
        queue.add(a);
        System.out.println(queue);

        int b = 2;
        // 入队列
        queue.offer(b);
        System.out.println(queue);

        // 顶部元素出队列，但不会删除顶部元素
        System.out.println(queue.peek());

        // 顶部元素出队列，同时会删除顶部元素
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
