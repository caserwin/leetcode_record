package special.brackets;

/**
 * User: caserwin
 * Date: 2021/10/8 9:23 上午
 * Description:
 */
public class Code921 {

    public static void main(String[] args) {
        String ss = "(((((((())";
        System.out.println(new Code921().minAddToMakeValid(ss));
    }

    public int minAddToMakeValid(String s) {
        char[] cs = s.toCharArray();

        // 记录左右需要的括号个数
        int rightNum = 0;
        int leftNum = 0;

        for (char c : cs) {
            if (c == '(') {
                rightNum++;
                continue;
            }

            if (c == ')') {
                rightNum--;
                // continue;
            }

            if (rightNum < 0) {
                leftNum++;
                rightNum++;
            }
        }
        return rightNum + leftNum;
    }
    /*
     * 1. 只有遇到右括号 ) 的时候才会 rightNum--，rightNum == -1 意味着右括号太多了，所以需要插入左括号。
     * 2. 注意注销的地方不能加 continue；
     */
}
