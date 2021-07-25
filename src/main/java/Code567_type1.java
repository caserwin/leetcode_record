import java.util.HashMap;
import java.util.Map;

/**
 * User: caserwin
 * Date: 2021-07-25 16:05
 * Description:
 */
public class Code567_type1 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    /**
     *  2021-07-25 16:05 实现，v1 版本
     */
    public static boolean checkInclusion(String s1, String s2) {
        boolean is = false;
        int left = 0;

        while (left < s2.length()) {
            int right = left;
            while (right <= s2.length()) {
                // TODO 这里要注意的是 substring() right是不包含在内的，即不能表示下标，而是表示实际长度
                String tmp = s2.substring(left, right);
                if (!ifContainStr(tmp.toCharArray(), s1.toCharArray())) {
                    right++;
                } else {
                    is = true;
                    break;
                }
            }
            left++;
        }

        return is;
    }

    private static boolean ifContainStr(char[] s, char[] cs) {
        if (s.length != cs.length) {
            return false;
        }
        HashMap<Character, Integer> csMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        boolean is = true;

        for (char c : cs) {
            if (!csMap.containsKey(c)) {
                csMap.put(c, 1);
            } else {
                csMap.put(c, csMap.get(c) + 1);
            }
        }

        for (char c : s) {
            if (!sMap.containsKey(c)) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> en : csMap.entrySet()) {
            if (!sMap.containsKey(en.getKey()) || sMap.get(en.getKey()).intValue() != en.getValue().intValue()) {
                is = false;
            }
        }

        for (Map.Entry<Character, Integer> en : sMap.entrySet()) {
            if (!csMap.containsKey(en.getKey()) || csMap.get(en.getKey()).intValue() != en.getValue().intValue()) {
                is = false;
            }
        }

        return is;
    }

}
