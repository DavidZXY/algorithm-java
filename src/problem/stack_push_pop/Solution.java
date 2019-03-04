package problem.stack_push_pop;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0)
            return false;

        int n = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < n; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && popA[popIndex] == stack.peek()) {
                popIndex++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
