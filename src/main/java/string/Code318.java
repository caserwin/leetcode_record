package string;

import java.util.HashSet;

/**
 * 最大单词长度乘积
 * 给定一个字符串数组words，找到length(word[i]) * length(word[j])的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。
 */
public class Code318 {
    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!isContain(words[i], words[j])) {
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        return maxLen;
    }

    private boolean isContain(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s1.toCharArray();

        HashSet<Character> chs1 = new HashSet<>();
        HashSet<Character> chs2 = new HashSet<>();

        for (char c : cs1) {
            chs1.add(c);
        }

        for (char c : cs2) {
            chs2.add(c);
        }

        for (Character character : chs1) {
            if (chs2.contains(character)) {
                return true;
            }
        }
        return false;
    }
}
