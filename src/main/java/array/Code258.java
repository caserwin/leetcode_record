package array;

/**
 * @author casyd_xue
 */
public class Code258 {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(new Code258().addDigits(num));
    }

    public int addDigits(int num) {
        String res = String.valueOf(num);
        char[] ss = res.toCharArray();
        while (res.length() > 1) {
            int tmp = 0;
            for (char s : ss) {
                tmp += Integer.parseInt(String.valueOf(s));
            }

            res = String.valueOf(tmp);
            ss = res.toCharArray();
        }
        return Integer.parseInt(res);
    }
}