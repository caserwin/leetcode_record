package fuxi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * User: caserwin
 * Date: 2023/6/10 4:42 下午
 * Description:
 * 1. 有n个格子，每个格子上有一个蘑菇，蘑菇分为好蘑菇和毒蘑菇，好蘑菇增加体力值, 坏蘑菇减少体力值
 * 2、人的初始体力值为m 人从格子外开始跳，跳的格子的距离与消耗的体力值成正比，正比关系是1:1
 * <p>
 * 问：
 * 问题1：判断是否可以跳到终点？
 * 问题2：如果可以返回最大剩余体力值
 * 问题3：返回跳到终点的路径
 */
public class Mgtiaoyitiao {
    public static void main(String[] args) {
        int[] array = {1, 2, -3, 4, 5, 6};
        int m = 5;

//        System.out.println(new Mgtiaoyitiao().isJump(array, m));
        System.out.println(new Mgtiaoyitiao().isJump2(array, m));
    }

//    public int isJump(int[] array, int m) {
//        // 记录跳到位置 i，最多剩余的体力
//        int[] dp = new int[array.length];
//        dp[0] = m + array[0] - 1;
//
//        for (int i = 1; i < array.length; i++) {
//            for (int j = 0; j < i; j++) {
//                dp[i] = Math.max(dp[j] + array[i] - (i - j), dp[i]);
//            }
//        }
//
//        return dp[array.length - 1];
//    }


    public int isJump2(int[] array, int m) {
        // 记录跳到位置 i，最多剩余的体力
        int[] dp = new int[array.length];
        // 初始化
        Arrays.fill(dp, 0);
        dp[0] = m + array[0] - 1;
        // 记录路径
        HashMap<Integer, Integer> trackMap = new HashMap<>();
        // 状态转移
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] < dp[j] + array[i] - (i - j)) {
                    dp[i] = dp[j] + array[i] - (i - j);
                    trackMap.put(i, j);
                }
            }
        }

        // 打印跳到终点的路径
        System.out.println(printTrack(trackMap, array.length - 1));

        // 打印跳到重点还有剩余最多的体力
        return dp[array.length - 1];
    }


    public String printTrack(HashMap<Integer, Integer> trackMap, int index) {
        if (index == 1) {
            return trackMap.get(1).toString();
        }
        return printTrack(trackMap, trackMap.get(index)) + "->" + index;
    }
}
