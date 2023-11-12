package shein20231026;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/10/29 15:42
 * Description:
 */
public class Code139 {
    public static void main(String[] args){
        String ss = "leetcode";
        String[] s = {"leet","code"};
        System.out.println(wordBreak(ss, Arrays.asList(s)));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示前 i 个字符是否可用 wordDict表示
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[j] && wordDict.contains(s.substring(j, i))) || dp[i];
            }
        }

        return dp[s.length()];

//                Set<String> wordDictSet = new HashSet(wordDict);
//                boolean[] dp = new boolean[s.length() + 1];
//                dp[0] = true;
//                for (int i = 1; i <= s.length(); i++) {
//                    for (int j = 0; j < i; j++) {
////                        if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
////                            dp[i] = true;
////                            break;
////                        }
//                        dp[i] = (dp[j] && wordDict.contains(s.substring(j, i))) || dp[i];
//                    }
//                }
//                return dp[s.length()];

    }
}
