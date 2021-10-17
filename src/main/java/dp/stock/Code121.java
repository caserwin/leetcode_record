package dp.stock;

/**
 * User: caserwin
 * Date: 2021-07-25 17:39
 * Description:
 */
public class Code121 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int tmpMin = Integer.MAX_VALUE;

        for (int price : prices) {
            tmpMin = Math.min(tmpMin, price);
            maxProfit = Math.max(maxProfit, price - tmpMin);
        }
        return maxProfit;
    }
}
