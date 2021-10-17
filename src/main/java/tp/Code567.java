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


    /**
     * 2021-07-25 16:05 实现，v1 版本
     */
    public static boolean checkInclusion1(String s1, String s2) {
        boolean is = false;
        int left = 0;

        while (left < s2.length()) {
            int right = left;
            while (right <= s2.length()) {
                // TODO 这里要注意的是 substring() right是不包含在内的，即不能表示下标，而是表示实际长度
                String tmp = s2.substring(left, right);
                if (!ifContainStr(tmp.toCharArray(), s1.toCharArray())) {
                    right++;
                } else {
                    is = true;
                    break;
                }
            }
            left++;
        }

        return is;
    }

    private static boolean ifContainStr(char[] s, char[] cs) {
        if (s.length != cs.length) {
            return false;
        }
        HashMap<Character, Integer> csMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        boolean is = true;

        for (char c : cs) {
            if (!csMap.containsKey(c)) {
                csMap.put(c, 1);
            } else {
                csMap.put(c, csMap.get(c) + 1);
            }
        }

        for (char c : s) {
            if (!sMap.containsKey(c)) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> en : csMap.entrySet()) {
            if (!sMap.containsKey(en.getKey()) || sMap.get(en.getKey()).intValue() != en.getValue().intValue()) {
                is = false;
            }
        }

        for (Map.Entry<Character, Integer> en : sMap.entrySet()) {
            if (!csMap.containsKey(en.getKey()) || csMap.get(en.getKey()).intValue() != en.getValue().intValue()) {
                is = false;
            }
        }

        return is;
    }
}
