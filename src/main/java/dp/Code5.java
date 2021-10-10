package dp;

/**
 * User: caserwin
 * Date: 2021/10/10 8:42 上午
 * Description:
 */
public class Code5 {

    public static void main(String[] args){
        String s = "babad";
        System.out.println(new Code5().longestPalindrome1(s));
    }

    /**
     * 1. 运行超时了
     * 2. 其实这不是一个标准的滑动窗口写法、因为滑动窗口 right 指针停下来会有给定的明确条件。
     *    但是这一题没有给定条件，"最大回文" 中的"最大" 条件是不能边遍历边判断的，只有完整遍历了一遍才能判断
     * 3. 官方给的解法：动态规划、Manacher、中心扩展法。
     */
    public String longestPalindrome1(String s) {
        String resStr = "";
        int left = 0;


        while (left < s.length()) {
            int right = left + 1;
            while (right <= s.length()) {
                String tmp = s.substring(left, right);
                if (isPalindrome(tmp)) {
                    if ("".equals(resStr)) {
                        resStr = tmp;
                        continue;
                    }
                    resStr = resStr.length() >= tmp.length() ? resStr : tmp;
                }
                right++;
            }
            left++;
        }
        return resStr;
    }

    //判断是否是回文串
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
