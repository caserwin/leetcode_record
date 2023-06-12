package fuxi;

import java.util.HashMap;
import java.util.Map;

/**
 * User: caserwin
 * Date: 2023/6/13 1:31 上午
 * Description:
 */
public class Alaboshuzizhuanzhongwen {
    public static void main(String[] args) {
        String s = "一千五百一十万五千五百三十二";
        System.out.println(calculate(s));
    }

    public static long calculate(String s) {
        int wIndex = s.lastIndexOf("万");
        if (wIndex != -1) {
            return subCal(s.substring(0, wIndex)) * 10000 + subCal(s.substring(wIndex + 1));
        }
        return subCal(s);
    }

    private static long subCal(String s) {
        if ("".equals(s.trim())) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('一', 1);
        map.put('二', 2);
        map.put('三', 3);
        map.put('四', 4);
        map.put('五', 5);
        map.put('六', 6);
        map.put('七', 7);
        map.put('八', 8);
        map.put('九', 9);

        int tenIndex = s.indexOf("十");
        int hanIndex = s.indexOf("百");
        int thouIndex = s.indexOf("千");
        long res = 0;
        if (thouIndex != -1) {
            res = res + map.get(s.charAt(thouIndex - 1)) * 1000;
        }
        if (hanIndex != -1) {
            res = res + map.get(s.charAt(hanIndex - 1)) * 100;
        }
        if (tenIndex != -1) {
//            res = res + ((tenIndex - 1 < 0 ? 1 : map.get(s.charAt(tenIndex - 1))) * 10);
            res = res + map.get(s.charAt(tenIndex - 1)) * 10;
        }
        if (map.containsKey(s.charAt(s.length() - 1))) {
            res = res + map.get(s.charAt(s.length() - 1));
        }
        return res;
    }
}
