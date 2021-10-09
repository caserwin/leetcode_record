package bitOper;

/**
 * 136 只出现一次的数字
 * 本质是异或运算：相同为0，不同为1。对应 java 中的是 ^ 运算符
 */
public class Code136 {

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
