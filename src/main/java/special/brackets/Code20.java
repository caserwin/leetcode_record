package special.brackets;

import java.util.HashMap;
import java.util.Stack;

/**
 * User: caserwin
 * Date: 2021/7/25 10:07 下午
 * Description:
 */
public class Code20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("]"));

    }

    public static boolean isValid(String s) {
        boolean is = true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cs) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (map.containsValue(c)) {
                    if (stack.empty() || map.get(stack.pop()) != c) {
                        is = false;
                    }
                }
            }
        }

        if (!stack.empty()) {
            is = false;
        }

        return is;
    }
}
