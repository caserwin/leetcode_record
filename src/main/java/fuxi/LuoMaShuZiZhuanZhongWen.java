package fuxi;

import java.util.HashMap;

/**
 * User: caserwin
 * Date: 2023/6/24 3:39 下午
 * Description:
 * 核心记住：
 * 1. 比如 8 这样的是会写成 VIII，而不是 IIX.
 * 2. 9 这样的只会写成 IX，而不是 VIIII
 */
public class LuoMaShuZiZhuanZhongWen {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new LuoMaShuZiZhuanZhongWen().romanToInt(s));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }

        char[] cs = s.toCharArray();
        int sum = 0;
        for (int i = 1; i < cs.length; i++) {
            if (map.get(cs[i - 1]) < map.get(cs[i])) {
                sum += map.get(cs[i]) - map.get(cs[i - 1]);
                i++;
            } else {
                sum += map.get(cs[i - 1]);
            }
        }

        if (map.get(cs[cs.length - 2]) >= map.get(cs[cs.length - 1])) {
            sum += map.get(cs[cs.length - 1]);
        }

        return sum;
    }
}
