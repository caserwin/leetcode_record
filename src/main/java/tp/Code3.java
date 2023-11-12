package tp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author yidxue
 */
public class Code3 {

    public static void main(String[] args) {
        System.out.println(new Code3().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int right = 0;

        int maxLen = Integer.MIN_VALUE;
        LinkedList<Character> linkedList = new LinkedList<>();
        while (right < cs.length) {
            // 一直 add，到条件不满足为止
            if (!linkedList.contains(cs[right])) {
                linkedList.add(cs[right]);
                maxLen = Math.max(maxLen, linkedList.size());
                right++;
            } else {
                linkedList.removeFirst();
            }
        }
        return maxLen;
    }


    public static int lengthOfLongestSubstring1(String s) {
        char[] cs = s.toCharArray();

        // 从每一个字符开始的，不包含重复字符的最长子串
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<String> set;

        int left = 0;

        while (left < cs.length) {
            set = new HashSet<>();
            int right = left;
            while (right < cs.length) {
                if (!set.contains(String.valueOf(cs[right]))) {
                    set.add(String.valueOf(cs[right]));
                    right++;
                } else {
                    break;
                }
            }

            list.add(set.size());
            left++;
        }

        int maxLength = 0;
        for (Integer num : list) {
            maxLength = num > maxLength ? num : maxLength;
        }

        return maxLength;
    }
}
