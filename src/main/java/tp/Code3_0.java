package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * User: caserwin
 * Date: 2021-07-25 11:56
 * Description:
 */
public class Code3_0 {


    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("jxdlnaaij"));
//        System.out.println(lengthOfLongestSubstring("abc"));

    }

    /**
     * 找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。
     * <p>
     * TODO: 必须记得是 left < cs.length，而不是 right < cs.length
     */
    public static int lengthOfLongestSubstring(String s) {
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