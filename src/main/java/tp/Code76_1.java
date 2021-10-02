package tp;

import java.util.LinkedList;

public class Code76_1 {

    public static void main(String[] args) {
        String S = "a";
        String T = "a";
        System.out.println(new Code76_1().minWindow(S, T));
    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int minLen = Integer.MAX_VALUE;
        // 存滑动字符串
        LinkedList<Character> linkedList = new LinkedList<>();
        // 存结果字符串
        String str = "";
        while (right < s.length()) {
            linkedList.add(ss[right]);
            if (jugde(linkedList, ts)) {
                // 如果包含，先记录最小长度和临时结果
                if (minLen > linkedList.size()) {
                    minLen = linkedList.size();
                    str = listToString(linkedList);
                }
                // 移除 left 元素
                linkedList.removeFirst();
                left++;
                while (left < right) {
                    if (jugde(linkedList, ts)) {
                        // 如果包含，先记录最小长度和临时结果
                        if (minLen > linkedList.size()) {
                            minLen = linkedList.size();
                            str = listToString(linkedList);
                        }
                        linkedList.removeFirst();
                        right++;
                        left++;
                    } else {
                        right++;
                        break;
                    }
                }
            } else {
                right++;
            }
        }
        return str;
    }


    private boolean jugde(LinkedList<Character> linkedList, char[] ts) {
        for (Character c : ts) {
            if (!linkedList.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private String listToString(LinkedList<Character> linkedList) {
        LinkedList<Character> tmp = new LinkedList<>(linkedList);
        StringBuilder res = new StringBuilder();
        for (Character character : tmp) {
            res.append(character);
        }
        return res.toString();
    }
}
