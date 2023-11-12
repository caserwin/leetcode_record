package shein20231026;

import java.util.LinkedList;

/**
 * User: caserwin
 * Date: 2023/10/26 23:42
 * Description:
 */
public class Code3 {

    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int right = 0;

        LinkedList<Character> linkedList = new LinkedList<>();
        int maxLen = 0;
        while (right < cs.length){
            if (!linkedList.contains(cs[right])){
                linkedList.add(cs[right]);
                right ++;
                maxLen = Math.max(maxLen, linkedList.size());
            }else {
                while (linkedList.contains(cs[right])){
                    linkedList.removeFirst();
                }
                maxLen = Math.max(maxLen, linkedList.size());
            }
        }
        return maxLen;
    }
}
