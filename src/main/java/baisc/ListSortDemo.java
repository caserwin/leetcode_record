package baisc;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author casyd_xue
 */
public class ListSortDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(2);
        list2.sort(Comparator.reverseOrder());
        System.out.println(list2);
        list2.sort(Comparator.naturalOrder());
        System.out.println(list2);
    }
}
