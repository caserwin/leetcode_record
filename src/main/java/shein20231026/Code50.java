package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/28 23:39
 * Description:
 */
public class Code50 {
    public static void main(String[] args){
        System.out.println(myPow(2,10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2, -2));
    }
    public static double myPow(double x, int n) {
        double res = 1;
        if (n==0 || x==1){
            return 1;
        }
        if (n > 0){
            while (n > 0){
                res = res * x;
                n--;
            }
        }
        if (n < 0){
            while (n < 0){
                res = res / x;
                n++;
            }
        }
        return res;
    }
}
