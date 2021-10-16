package rand;

/**
 * @author yidxue
 * Code470：用 Rand7() 实现 Rand10()
 */
public class Code470 {
    /**
     * 核心：(rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成 [1, X * Y] 范围的随机数即实现了 rand_XY()
     */
    public int rand10() {
        // 拒绝采样
        while (true) {
            int num = 7 * (rand7() - 1) + rand7();
            if (num <= 40) {
                // 需要返回[1,10]范围的随机数
                return num % 10 + 1;
            }
        }
    }

    public int rand7() {
        return 0;
    }
}
