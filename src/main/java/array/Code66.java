package array;


/**
 * @author yidxue
 * 加一：https://leetcode-cn.com/problems/plus-one/
 */
public class Code66 {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        // 直接末尾 + 1
        digits[digits.length - 1] = digits[digits.length - 1] + 1;

        // 记录是否进位
        int flag = 0;

        // 判断要不要进位
        for (int i = 0; i < digits.length; i++) {
            if (digits[digits.length - i - 1] > 9) {
                digits[digits.length - i - 1] = digits[digits.length - i - 1] - 10;
                if (digits.length - i - 2 >= 0) {
                    digits[digits.length - i - 2] = digits[digits.length - i - 2] + 1;
                } else {
                    //记录进位
                    flag = 1;
                    break;
                }
            } else {
                break;
            }
        }

        // 是否进位的不同处理方式
        if (flag == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
    }
}
