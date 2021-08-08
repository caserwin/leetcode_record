package shuxuejisuan;

/**
 * User: caserwin
 * Date: 2021/8/8 11:36 上午
 * Description:
 */
public class Code69 {

    public static void main(String[] args) {
        System.out.println(new Code69().mySqrt(1));
        System.out.println(new Code69().mySqrt(4));
        System.out.println(new Code69().mySqrt(2147483647));
        System.out.println(new Code69().mySqrt(9));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int num = x / 2 + 1;
        for (int i = 0; i <= num; i++) {
            if (i * i == x) {
                return i;
            }
            if (i * i < x && (i + 1) * (i + 1) > x || (i + 1) * (i + 1) < 0) {
                return i;
            }
        }
        return -1;
    }
}
