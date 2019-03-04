package problem.find_continuous_sequence;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int l = 1;
        int r = 2;
        while (l < r) {
            int temp = (l + r) * (r - l + 1) / 2;
            if (temp == sum) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    arr.add(i);
                }
                list.add(arr);
                l++;
            }
            else if (temp > sum){
                l++;
            } else {
                r++;
            }
        }
        return list;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int index = Arrays.binarySearch(array, sum - array[i]);
            if (index > 0) {
                list.add(array[i]);
                list.add(array[index]);
                break;
            }
        }
        return list;
    }

    public static String ReverseSentence(String str) {
        if (str.length() <= 1) {
            return str;
        }
        StringBuilder builder = new StringBuilder();
        String[] temp = str.split(" ");
        for (int i = temp.length - 1; i > 0; i--) {
            builder.append(temp[i] + " ");
        }
        builder.append(temp[0]);
        return builder.toString();
    }

    public static void main(String[] args) {
        ReverseSentence(" ");
    }
}
