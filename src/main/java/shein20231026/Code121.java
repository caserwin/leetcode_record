package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/29 11:44
 * Description:
 */
public class Code121 {
    public int maxProfit(int[] prices) {
        int buyInMin = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            buyInMin = Math.min(buyInMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-buyInMin);
        }
        return maxProfit;
    }
}
