package problem.ugly_number;

public class Solution {

    public static int GetUglyNumber_Solution(int index) {
        if (index < 7)
            return index;

        int[] arr = new int[index];
        arr[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1 ; i < index; i++) {
            arr[i] = Math.min(arr[t2] * 2, Math.min(arr[t3] * 3, arr[t5] * 5));
            if (arr[i] == arr[t2] * 2)
                t2++;
            if (arr[i] == arr[t3] * 3)
                t3++;
            if (arr[i] == arr[t5] * 5)
                t5++;
        }
        return arr[index - 1];
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution(7);
    }
}
