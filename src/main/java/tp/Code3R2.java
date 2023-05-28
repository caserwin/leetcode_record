package tp;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * User: caserwin
 * Date: 2021/11/21 2:40 下午
 * Description:
 */
public class Code3R2 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        if (cs.length == 0 || cs.length == 1) {
            return cs.length;
        }

        int right = 1;
        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add(cs[0]);
        int maxLen = Integer.MIN_VALUE;
        while (right < s.length()) {
            if (!linkedList.contains(cs[right])) {
                linkedList.add(cs[right]);
                maxLen = Math.max(linkedList.size(), maxLen);
                right++;
            } else {
                linkedList.removeFirst();
            }
        }
        return maxLen;
    }
}