package problem.string_permutation;

import java.util.ArrayList;

public class Solution {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        ArrayList<Character> temp = new ArrayList<>(16);
        for (int i = 0; i < str.length(); i++) {
            temp.add(str.charAt(i));
        }
        for (int i = 0; i < temp.size(); i++) {
            builder.append(temp.get(i));
        }
        builder.delete(0, temp.size() - 1);

        return res;
    }
}
