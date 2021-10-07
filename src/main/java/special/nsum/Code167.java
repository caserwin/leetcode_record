package special.nsum;

import java.util.Arrays;

/**
 * User: caserwin
 * Date: 2021/10/7 10:54 下午
 * Description:
 */
public class Code167 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(new Code167().twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
                continue;
            }

            if (numbers[left] + numbers[right] < target) {
                left++;
                continue;
            }

            if (numbers[left] + numbers[right] == target) {
                break;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
