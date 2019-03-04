package problem.fibonacci;

public class Solution {

    public int Fibonacci(int n) {
        //if (n == 0)
        //    return 0;
        //if (n == 1)
        //    return 1;
        //return Fibonacci(n - 1) + Fibonacci(n - 2);
        if (n <= 1)
            return n;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = b;
            b = b + a;
            a = c;
        }
        return b;
    }

    public int JumpFloor(int target) {
        //if (target == 1) {
        //    return 1;
        //}
        //if (target == 2) {
        //    return 2;
        //}
        //return JumpFloor(target - 1) + JumpFloor(target - 2);
        if (target <= 2) {
            return target;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= target; i++) {
            c = b;
            b = b + a;
            a = c;
        }
        return b;
    }

    public int JumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
