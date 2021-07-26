import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/7/26 5:12 下午
 * Description:
 */
public class Code448 {

    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] numArr = new int[n];

        for (int num : nums) {
            numArr[num - 1] = 1;
        }

        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] == 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
