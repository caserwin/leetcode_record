package baisc;

import java.util.*;

/**
 * @author casyd_xue
 */
public class TipsSortDemo {
    public static void main(String[] args) {
        System.out.println("================ Array 排序 ================");
        Integer[] a = new Integer[3];
        a[0] = 1;
        a[1] = 3;
        a[2] = 2;
        // Arrays.sort(a); 默认 Comparator.naturalOrder() 实现
        Arrays.sort(a, Comparator.naturalOrder());
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Comparator.reverseOrder());
        System.out.println(Arrays.toString(a));
        System.out.println("================ List 排序 ================");

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        System.out.println("================ List 自定义 Comparator ================");
        List<int[]> list1 = new ArrayList<>();
        list1.add(new int[]{1, 2});
        list1.add(new int[]{2, 3});
        list1.add(new int[]{4, 3});
        list1.add(new int[]{3, 3});
        list1.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] i : list1) {
            System.out.print(Arrays.toString(i));
        }
    }
}