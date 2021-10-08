package special.brackets;

/**
 * User: caserwin
 * Date: 2021/10/8 9:25 上午
 * Description:
 */
public class Code1541 {
    public static void main(String[] args) {
        String ss = ")))))))";
        System.out.println(new Code921().minAddToMakeValid(ss));
    }

    public int minInsertions(String s) {
        char[] cs = s.toCharArray();

        // 记录左右需要的括号个数
        int rightNum = 0;
        int leftNum = 0;
        for (char c : cs) {
            if (c == '(') {
                rightNum += 2;
                if (rightNum % 2 == 1) {
                    // 插入一个左括号
                    leftNum++;
                    // 对右括号的需求减一
                    rightNum--;
                }
            }

            // 处理右括号
            if (c == ')') {
                rightNum--;
            }
            // 相当于右括号多了一个，这时候需要加一个左括号，同时需要再加一个右括号。相当于需要两个右括号
            if (rightNum == -1) {
                leftNum++;
                rightNum += 2;
            }
        }

        return leftNum + rightNum;
    }
}
