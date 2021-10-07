package tp;

/**
 * User: caserwin
 * Date: 2021/7/26 11:45 上午
 * Description:
 */
public class Code739 {
    public static void main(String[] args) {
        int[] num = {55, 38, 53, 81, 61, 93, 97, 32, 43, 78};
        int[] res = dailyTemperatures(num);

        for (int i : res) {
            System.out.println(i);
        }
    }

    /**
     * TODO 错误：和code 27和27联合一起看，if (!is) 不能有 break。
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int left = 0;
        while (left < temperatures.length) {
            int right = left;
            boolean is = false;
            while (right < temperatures.length) {
                if (temperatures[right] > temperatures[left]) {
                    res[left] = right - left;
                    is = true;
                    break;
                } else {
                    right++;
                }
            }
            if (!is) {
                res[left] = 0;
            }
            left++;
        }
        return res;
    }
}
