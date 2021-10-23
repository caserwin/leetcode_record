package dfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yidxue
 * 复原 IP 地址
 */
public class Code93 {

    public static void main(String[] args) {
        String s = "25525511135";
//        String s = "1234";
        System.out.println(new Code93().restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        // 结果列表
        List<String> resLs = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) {
            return resLs;
        }
        // 路径列表
        LinkedList<String> track = new LinkedList<>();

        // 开始回溯
        dfs(s, 0, track, resLs);

        return resLs;
    }

    /**
     * 1. 评价：我曹，试了n 多次做出来了。整体框架思路其实都没错，但是细节和边界太不到位了、不断调试才运行成功，中间有些逻辑都忘记了。下次写肯定做不到一次写出来、还得多尝试。
     * 2. 整体框架和78的子集问题很像，for循环中起始位是通过 dfs 传进来的。
     */
    private void dfs(String s, int index, LinkedList<String> track, List<String> resLs) {
        // 返回条件：track 路径长度应该是 s.length() + 3，且 s 要遍历到最后
        if (toString(track).length() == s.length() + 3 && index == s.length()) {
            resLs.add(toString(track));
            return;
        }

        // 这里是核心逻辑，调试多次才改成功，要非常注意
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String tmpNum = s.substring(index, i);
            // 基于剩下字符串的长度做剪支使用
            String endStr = s.substring(i);

            if (isVaild(tmpNum)) {
                track.add(tmpNum);
                track.add(".");
                dfs(s, i, track, resLs);
                track.removeLast();
                track.removeLast();
            }
        }
    }

    private boolean isVaild(String num) {
        if (num.length() > 1 && num.startsWith("0")) {
            return false;
        }
        return Integer.parseInt(num) <= 255 && Integer.parseInt(num) >= 0;
    }

    private String toString(LinkedList<String> linkedList) {
        StringBuilder res = new StringBuilder();
        for (String str : linkedList) {
            res.append(str);
        }
        return res.toString().endsWith(".") ? res.toString().substring(0, res.toString().length() - 1) : res.toString();
    }
}
