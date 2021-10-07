/**
 * User: caserwin
 * Date: 2021-07-25 16:51
 * Description:
 */
public class Code5_type1 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
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
    private static boolean isPalindrome(String s) {
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
