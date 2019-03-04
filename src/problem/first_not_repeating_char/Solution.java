package problem.first_not_repeating_char;

public class Solution {

    public static int FirstNotRepeatingChar(String str) {
        int[] arr = new int[123];
        int strlen = str.length();
        for (int i = 0; i < strlen; i++) {
            arr[(int)str.charAt(i)] += 1;
        }

        int i = 0;
        for (; i < strlen; i++) {
            if (arr[(int)str.charAt(i)] == 1) {
                break;
            }
        }
        if (i == strlen)
            return -1;
        return i ;
    }

    public static void main(String[] args) {
        int a =  FirstNotRepeatingChar("google");
        System.out.println(a);
    }
}
