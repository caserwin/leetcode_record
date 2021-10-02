package string;

/**
 * User: caserwin
 * Date: 2021/10/2 10:32 上午
 * Description:
 */
public class Code58 {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        String[] ss = s.split("\\s+");
        return ss[ss.length - 1].length();
    }
}
