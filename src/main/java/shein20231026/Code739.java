package shein20231026;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * User: caserwin
 * Date: 2023/11/1 00:13
 * Description:
 */
public class Code739 {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        int a = 1;
        stack.push(a);
        System.out.println(stack);

        int b =2;
        stack.push(b);
        System.out.println(stack);

        stack.peek();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
