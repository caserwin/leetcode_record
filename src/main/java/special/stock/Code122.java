package special.stock;

/**
 * User: caserwin
 * Date: 2021/7/26 4:42 下午
 * Description:
 */
public class Code122 {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));
    }

    /**
     * 只要是所有的上升通道就行
     */
    public static int maxProfit(int[] prices) {
        int sumProfit = 0;
        int i = 0;
        for (int j = 1; j < prices.length; i++, j++) {
            if (prices[j] > prices[i]) {
                sumProfit += prices[j] - prices[i];
            }
        }
        return sumProfit;
    }
}
