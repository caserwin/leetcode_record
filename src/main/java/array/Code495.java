package array;

/**
 * 提莫攻击
 */
public class Code495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            // 如果没有重叠就直接加上 duration
            if (timeSeries[i-1] + duration <= timeSeries[i]){
                time += duration;
            }else {
                // 如果有重叠则加上 (duration - 重叠部分时间)
                time += duration - (timeSeries[i-1] + duration - timeSeries[i]);
            }
        }
        return time + duration;
    }
}
