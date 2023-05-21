package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * User: caserwin
 * Date: 2023/5/21 6:00 下午
 * Description:
 */
public class Code784 {

    public static void main(String[] args) {
        String s = "a1b2";
        List<String> res = new Code784().letterCasePermutation(s);
        for (String re : res) {
            System.out.println(re);
        }
    }

    public List<String> letterCasePermutation(String s) {
        // 结果列表
        List<String> res = new ArrayList<>();
        // 路径列表
        LinkedList<String> track = new LinkedList<>();
        // dfs
        dfs(s.toCharArray(), res, track, 0);
        return res;
    }

    public void dfs(char[] cs, List<String> res, LinkedList<String> track, int index) {
        while (index < cs.length && Character.isDigit(cs[index])) {
            track.add(String.valueOf(cs[index]));
            index++;
        }

        if (cs.length == track.size()) {
            res.add(trackToString(track));
            return;
        }

        // 先小写
        track.add(String.valueOf(cs[index]).toLowerCase());
        dfs(cs, res, track, index + 1);
        while (isNum(track.get(track.size() - 1))) {
            track.removeLast();
        }
        track.removeLast();

        // 再大写
        track.add(String.valueOf(cs[index]).toUpperCase());
        dfs(cs, res, track, index + 1);
        while (isNum(track.get(track.size() - 1))) {
            track.removeLast();
        }
        track.removeLast();
    }

    public boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String trackToString(LinkedList<String> track) {
        StringBuilder ss = new StringBuilder();
        for (String s : track) {
            ss.append(s);
        }
        return ss.toString();
    }
}
