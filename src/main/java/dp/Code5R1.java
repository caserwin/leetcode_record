package dp;

/**
 * User: caserwin
 * Date: 2021/10/10 8:42 上午
 * Description:
 */
public class Code5R1 {

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(new Code5R1().longestPalindrome(s));
    }

    /**
     * 1. 运行超时了
     * 2. 其实这不是一个标准的滑动窗口写法、因为滑动窗口 right 指针停下来会有给定的明确条件。
     * 但是这一题没有给定条件，"最大回文" 中的"最大" 条件是不能边遍历边判断的，只有完整遍历了一遍才能判断
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


    /**
     * 1. 整体不熟练，看了官方思路和代码，才写出来的
     * 2. 计算 dp[i][j]需要知道 dp[i+1][j-1] 的状态，所以当你判断长度为 j-i+1 的字符串是不是回文串时，你需要事先知道长度为 j-i-1 的字符串是不是回文串。
     * 3. 还有几个注意事项，在以下代码中有注释
     */
    public String longestPalindrome(String s) {
        int len = s.length();

        // boolean[i][j] 表示s[i:j] 组成的串是否是回文子串
        boolean[][] dp = new boolean[len][len];

        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 转态转移
        for (int subStrLen = 2; subStrLen <= s.length(); subStrLen++) {
            for (int i = 0; i < dp.length; i++) {
                int j = i + subStrLen - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 这里是调试试出来的
                    if (i + 1 == j && j - 1 == i) {
                        dp[i][j] = true;
                        continue;
                    }
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }


        int maxLen = Integer.MIN_VALUE;
        int tmpStart = 0;
        int tmpEnd = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[i][j]) {
                    if (maxLen < j - i) {
                        maxLen = j - i;
                        tmpStart = i;
                        tmpEnd = j;
                    }
                }
            }
        }

        // 注意：tmpEnd + 1 是一个边界条件
        return s.substring(tmpStart, tmpEnd + 1);
    }
}