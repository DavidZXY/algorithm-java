package problem.find_appear_once;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (hashmap.containsKey(array[i])) {
                hashmap.put(array[i], hashmap.get(array[i]) + 1);
            }
            else {
                hashmap.put(array[i], 1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (hashmap.get(array[i]) == 1) {
                list.add(array[i]);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    public static void main(String[] args) {
        FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, new int[1], new int[1]);
    }
}
