package problem.print_min_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
