package shein20231026;

import java.util.HashMap;
import java.util.Stack;

/**
 * User: caserwin
 * Date: 2023/10/26 23:28
 * Description:
 */
public class Code20 {

    public static void main(String[] args){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        char[] cs = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : cs) {
            if (map.containsKey(c)) {
                stack.push(c);
                continue;
            }

            if (stack.size() == 0 || map.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
