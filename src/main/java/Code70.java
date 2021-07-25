/**
 * User: caserwin
 * Date: 2021/7/25 10:52 下午
 * Description:
 */
public class Code70 {

    public static void main(String[] args){
        System.out.println(climbStairsV2(1));
        System.out.println(climbStairsV2(2));
        System.out.println(climbStairsV2(3));

    }

    public static int climbStairsV2(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < num.length; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }

    /**
     * 版本 1
     */
    public int climbStairsV1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsV1(n - 1) + climbStairsV1(n - 2);
    }
}
