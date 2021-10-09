package sort;

/**
 * @author yidxue
 *  179：最大数
 *  核心：判断两个字符串的拼接 ab 和 ba 的数字大小。如果 ab > ba，则把 a 排在前面，否则把 b 排在前面
 */
public class Code179 {
    public static void main(String[] args) {
        int[] nums = {999999991, 9};
        System.out.println(new Code179().largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long a = Long.parseLong(String.valueOf(nums[i]) + nums[j]);
                long b = Long.parseLong(String.valueOf(nums[j]) + nums[i]);
                if (a < b) {
                    swap(nums, i, j);
                }
            }
        }

        // 这是边界条件，很容易出错
        if (nums[0] == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
