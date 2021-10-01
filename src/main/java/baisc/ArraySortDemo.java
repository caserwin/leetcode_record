package baisc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author casyd_xue
 */
public class ArraySortDemo {
    public static void main(String[] args) {
        Integer[] a = new Integer[3];
        a[0] = 1;
        a[1] = 3;
        a[2] = 2;
        Arrays.sort(a, Comparator.naturalOrder());
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Comparator.reverseOrder());
        System.out.println(Arrays.toString(a));
    }
}