package tp;

import java.util.*;

/**
 * @author yidxue
 */
public class Code567 {
    public static void main(String[] args) {
//        String a = "abcdef";
//        System.out.println(a.substring(0, 2));
        String s1 = "ab";
        String s2 = "eidboaoo";

        System.out.println(new Code567().checkInclusion(s1, s2));
    }

    /**
     * 固定滑动窗口
     */
    public boolean checkInclusion(String s1, String s2) {
        int windows = s1.length();
        int left = 0;
        int right = 0;

        for (int i = 0; i < s2.length() - windows + 1 && right < s2.length(); i++) {
            left = i;
            right = left + windows - 1;

            String tmp = s2.substring(left, right + 1);
            if (judge(s1, tmp)) {
                return true;
            }
        }
        return false;
    }

    private boolean judge(String s1, String s2) {
        List<String> list1 = Arrays.asList(s1.split(""));
        List<String> list2 = Arrays.asList(s2.split(""));

        if (list1.size() != list2.size()) {
            return false;
        }

        list1.sort(Comparator.naturalOrder());
        list2.sort(Comparator.naturalOrder());

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
