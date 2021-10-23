package math;

/**
 * @author yidxue
 * 构造矩形
 */
public class Code492 {

    public static void main(String[] args) {
        int[] nums = new Code492().constructRectangle1(4);
        System.out.println(nums[0] + "->" + nums[1]);
    }

    /**
     * 超时
     */
    public int[] constructRectangle(int area) {
        int maxNum = (int) Math.sqrt(area);
        int gl = 0;
        int gw = 0;
        int min = Integer.MAX_VALUE;
        // 保证l 肯定大于 w
        for (int w = 0; w <= maxNum; w++) {
            for (int l = w; l <= area; l++) {
                if (l * w == area && l - w <= min) {
                    gl = l;
                    gw = w;
                    min = l - w;
                }
            }
        }
        return new int[]{gl, gw};
    }


    public int[] constructRectangle1(int area) {
        int maxNum = (int) Math.sqrt(area);
        int gl = 0;
        int gw = 0;
        int min = Integer.MAX_VALUE;
        // 保证l 肯定大于 w
        for (int w = 1; w <= maxNum; w++) {
            if (area % w == 0) {
                int l = area / w;
                if (l >= w && l - w <= min) {
                    gl = l;
                    gw = w;
                    min = l - w;
                }
            }
        }
        return new int[]{gl, gw};
    }
}
