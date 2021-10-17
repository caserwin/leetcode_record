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


    /**
     * 2021-07-25 16:20 实现，v1 版本
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int left = 0;

        while (left < s.length()) {
            int right = left;
            while (right <= s.length()) {
                // TODO 这里要注意的是 substring() right是不包含在内的，即不能表示下标，而是表示实际长度
                String tmp = s.substring(left, right);
                if (!ifContainStr(tmp.toCharArray(), p.toCharArray())) {
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