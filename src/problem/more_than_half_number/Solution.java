package problem.more_than_half_number;

import java.util.HashMap;

public class Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(array[i])) {
                hashMap.put(array[i], hashMap.get(array[i]));
                if (hashMap.get(array[i]) > n / 2) {
                    return array[i];
                }
            }
            else {
                hashMap.put(array[i], 1);
            }
        }
        return 0;
    }
}
