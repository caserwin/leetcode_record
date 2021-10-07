package math;

/**
 * User: caserwin
 * Date: 2021/10/7 10:39 上午
 * Description:
 */
public class Code50 {

    /**
     * 要知道快速幂运算
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N > 0) {
            return myPowTmp(x, N);
        } else if (N == 0) {
            return 1;
        } else {
            return 1 / myPowTmp(x, N * (-1));
        }
    }

    public double myPowTmp(double x, long n) {
        if (n == 1) {
            return x;
        }
        //    return x * myPowTmp(x, n - 1);
        double y = myPowTmp(x, n / 2);
        // 要知道快速幂运算 技巧
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
