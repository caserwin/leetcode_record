package fuxi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/11/21 2:40 下午
 * Description:
 */
public class LeetCode3 {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int left = 0;
        int right = left;
        int maxLen = 0;
        String tmpStr = "";

        while (right < cs.length) {
            if (!tmpStr.contains(String.valueOf(cs[right]))) {
                tmpStr = s.substring(left, right + 1);
                maxLen = Math.max(maxLen, tmpStr.length());
                // 移动右边窗口
                right++;
            } else {
                while (tmpStr.contains(String.valueOf(cs[right]))) {
                    // 移动左边边窗口
                    left++;
                    tmpStr = s.substring(left, right + 1);
                }
            }
        }

        return maxLen;
    }
}