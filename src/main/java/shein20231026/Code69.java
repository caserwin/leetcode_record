package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/30 08:16
 * Description:
 */
public class Code69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1){
            return x;
        }

        int num = x / 2;
        int res = 0;
        for (int i = 2; i < num; i++) {
            if (i * i <= x && (i+1)*(i+1) > x){
                res = i;
            }
        }
        return res;
    }
}
