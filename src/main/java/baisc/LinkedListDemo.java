package baisc;

import java.util.LinkedList;

/**
 * @author casyd_xue
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(2);
        System.out.println(linkedList.removeLast());

        // Offer First 和 Last 比较有用
        linkedList.offer(4);
        linkedList.offerFirst(5);
        linkedList.offerLast(6);
        System.out.println(linkedList);
    }
}