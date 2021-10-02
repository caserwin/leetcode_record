package tp;

import java.util.*;

/**
 * @author casyd_xue
 */
public class Code438 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int left = 0;

        while (left < s.length()) {
            int right = left;
            while (right <= s.length()) {
                // TODO 这里要注意的是 substring() right是不包含在内的，即不能表示下标，而是表示实际长度
                String tmp = s.substring(left, right);
                if (!judge(tmp, p)) {
                    right++;
                } else {
                    list.add(left);
                    break;
                }
            }
            left++;
        }

        return list;
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