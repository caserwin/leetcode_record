import java.util.HashMap;
import java.util.Map;

/**
 * User: caserwin
 * Date: 2021-07-25 15:15
 * Description:
 */
public class Code76_type1 {
    public static void main(String[] args) {
        String s = "qxsncfwvbslazxuoxnedkukropehlwfbwxqycntdfgghecvdqbhcwtukkauwzzzvystcfohmupvastekunmqiidtjxriyqdyiyapohekxblrurbpgphoykjhjarhtwfduhvkpzumahdxagmivtxvgiepjvxetehnmczddurgdwdecrmzklxqubgfzfjslqizvheadvghrlnvcbxpnuhjxpqywzrkrbjokqpolxxflkapnzeatmltdbrackkwlvmwlbmxbjcmvebieilzwyszckzgulcihpgsssrtdvhaaligvvfrwaqyksegdjqmywfsoyotuxtwieefbjwxjpxvhcemnwzntgfjetdatyydecjgofdzudxbfbqsxpfsvmebijcbhcemfnuvtzupcrthujbuyiovvswdbagjdkxkyrftqbktvdcpogloqajlsgquiyfljcxjveengogbulsitexjeixwqpszoxkzzkiuooiweqxydqjywiiaqhyhwrgkosloetktjuponposfxrdhzdyibhesprjjczoyjhhgyxtnmlulextdatnecsyrlhangonsxxywutligguldpqgiemkymdjufycumwtjupfpdowjkjozzwjdivbvymrdlvzzstkmkpenfcyplnqkjzquutrsgiytdxsvsckftquzstqdihnrgfnbbevjovcutupnyburrpsjijmsqclyjzzk";
        String t = "fxtusxonrfdrhxjamdkwm";

        System.out.println(minWindow(s, t));
    }

    /**
     *  2021-07-25 15:15 实现，v1 版本
     */
    public static String minWindow(String s, String t) {

        String minStr = "";
        int left = 0;

        while (left < s.length()) {
            int right = left;
            while (right <= s.length()) {
                String tmp = s.substring(left, right);
                if (!ifContainStr(tmp.toCharArray(), t.toCharArray())) {
                    right++;
                } else {
                    if ("".equals(minStr)) {
                        minStr = tmp;
                    }
                    minStr = minStr.length() < tmp.length() ? minStr : tmp;
                    break;
                }
            }
            left++;
        }

        return minStr;
    }


    private static boolean ifContainStr(char[] s, char[] cs) {
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
            if (!sMap.containsKey(en.getKey()) || sMap.get(en.getKey()) < en.getValue()) {
                is = false;
            }
        }
        return is;
    }

}
