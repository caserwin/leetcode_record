package baisc;

import java.util.Arrays;
import java.util.List;

/**
 * @author yidxue
 */
public class StringToArrayDemo {
    public static void main(String[] args) {
        String s = "abc";
        List<String> ls = Arrays.asList(s.split(""));
        System.out.println(ls);
    }

}
