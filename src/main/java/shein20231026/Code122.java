package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/29 11:44
 * Description:
 */
public class Code122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int init = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > init){
                maxProfit += prices[i] - init;
            } else {
                init = prices[i];
            }
        }
        return maxProfit;
    }
}
