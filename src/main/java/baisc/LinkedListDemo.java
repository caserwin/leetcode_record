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
        System.out.println(linkedList);
        System.out.println(linkedList.removeLast());
    }
}