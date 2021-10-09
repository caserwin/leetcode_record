package tp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yidxue
 * <p>
 * 用一个字典need来表示当前滑动窗口中需要的各元素的数量，一开始滑动窗口为空，用T中各元素来初始化这个need，当滑动窗口扩展或者收缩的时候，
 * 去维护这个need字典，例如当滑动窗口包含某个元素，我们就让need中这个元素的数量减1，代表所需元素减少了1个；
 * 当滑动窗口移除某个元素，就让need中这个元素的数量加1。
 */
public class Code76 {

    public static void main(String[] args) {
        String S = "a";
        String T = "a";

        System.out.println(new Code76().minWindow(S, T));
    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int minLen = Integer.MAX_VALUE;
        // 之所以赋值 -1，是为了处理一些边界条件
        int globalL = -1;
        int globalR = 0;

        // 用于存放当前滑动窗口是否包含了全部的目标字符，如果 map 中value 是负数，说明已经全部包含
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : ts) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        while (right < cs.length) {
            if (map.containsKey(cs[right])) {
                map.put(cs[right], map.get(cs[right]) - 1);
            }
            // 当前的滑动窗口[left, right]中，已经完全包含了 t 中所的字符
            if (judge(map)) {
                // 注意这里等号必须要取到，也是一个小坑
                while (left <= right) {
                    if (map.containsKey(cs[left])) {
                        map.put(cs[left], map.get(cs[left]) + 1);
                        // 如果去掉 cs[left] 字符后，不满足条件。则：1. 计算当前满足条件的最小长度。2. left++
                        if (!judge(map)) {
                            if (minLen > right - left + 1) {
                                minLen = right - left + 1;
                                globalL = left;
                                globalR = right;
                            }
                            left++;
                            break;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        return globalL > -1 ? s.substring(globalL, globalR + 1) : "";
    }

    /**
     * 用于判断当前的滑动窗口是否全部包含了目标的所有字符
     */
    private boolean judge(HashMap<Character, Integer> map) {
        for (Integer integer : map.values()) {
            if (integer > 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 2021-07-25 15:15 实现，v1 版本。。提交的时候报超时异常了
     */
    public static String minWindow1(String s, String t) {

        String minStr = "";
        int left = 0;

        while (left < s.length()) {
            int right = left;
            while (right <= s.length()) {
                String tmp = s.substring(left, right);
                if (!ifContainStr(tmp.toCharArray(), t.toCharArray())) {
                    right++;
                } else {
                    if ("".equals(minStr)) {
                        minStr = tmp;
                    }
                    minStr = minStr.length() < tmp.length() ? minStr : tmp;
                    break;
                }
            }
            left++;
        }

        return minStr;
    }


    private static boolean ifContainStr(char[] s, char[] cs) {
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
            if (!sMap.containsKey(en.getKey()) || sMap.get(en.getKey()) < en.getValue()) {
                is = false;
            }
        }
        return is;
    }
}
