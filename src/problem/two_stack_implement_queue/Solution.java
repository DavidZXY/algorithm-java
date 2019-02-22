package problem.two_stack_implement_queue;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.size() == 0 && stack2.size() == 0) {
            throw new EmptyStackException();
        }
        if (!stack2.isEmpty())
            return stack2.pop();
        else {
            int n = stack1.size();
            for (int i = 0; i < stack1.size(); i++) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        solution.push(4);
        System.out.println(solution.pop());
        solution.push(5);
        System.out.println(solution.pop());
        System.out.println(solution.pop());

    }
}
