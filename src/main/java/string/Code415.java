package string;

/**
 * User: caserwin
 * Date: 2021/10/10 8:22 上午
 * Description: 字符串相加
 */
public class Code415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 判断是否要进位
        boolean flag = false;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int tmpNum = 0;
            if (flag) {
                tmpNum += 1;
                flag = false;
            }

            if (i >= 0) {
                tmpNum += Integer.parseInt(String.valueOf(num1.charAt(i)));
                i--;
            }

            if (j >= 0) {
                tmpNum += Integer.parseInt(String.valueOf(num2.charAt(j)));
                j--;
            }

            if (tmpNum >= 10) {
                tmpNum -= 10;
                flag = true;
            }
            res.append(tmpNum);
        }

        // 注意：边界条件，如果跳出循环后 flag 还是等于 true，则最后还需要进位
        if (flag){
            res.append("1");
        }

        return reverse(res.toString());
    }

    private String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
}
