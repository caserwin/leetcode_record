package tp;

import java.util.LinkedList;

/**
 * @author yidxue
 */
public class Code3_1 {

    public static void main(String[] args) {
        System.out.println(new Code3_1().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int left = 0;
        int right = 0;

        int maxLen = Integer.MIN_VALUE;
        LinkedList<Character> linkedList = new LinkedList<>();
        while (right < cs.length) {
            // 一直 add，到条件不满足为止
            if (!linkedList.contains(cs[right])) {
                linkedList.add(cs[right]);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                // 出现重复的字符，把最左边的移除
                while (left < right) {
                    linkedList.removeFirst();
                    left++;
                    if (!linkedList.contains(cs[right])) {
                        maxLen = Math.max(maxLen, right - left + 1);
                        break;
                    }
                }
            }
        }
        return maxLen;
    }
}
