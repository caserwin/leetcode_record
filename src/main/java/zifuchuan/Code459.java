package zifuchuan;

/**
 * User: caserwin
 * Date: 2021/8/8 11:10 上午
 * Description:
 */
public class Code459 {
    public static void main(String[] args) {
        System.out.println(new Code459().repeatedSubstringPattern("a"));
    }

    /**
     * 超时
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 1) {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            String subStr = s.substring(0, i);
            if (judgeRepeatedSubstringPattern(subStr, s)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeRepeatedSubstringPattern(String subStr, String s) {
        String a = s.replace(subStr, "");
        return "".equals(a);
    }
}
