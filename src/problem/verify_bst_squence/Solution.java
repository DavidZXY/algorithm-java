package problem.verify_bst_squence;

public class Solution {

    public boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence == null || sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;

        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySequenceOfBST(int[] sequence, int l, int r) {
        if (l >= r)
            return true;
        int root = sequence[r];
        int i = l;
        while (sequence[i] < root) {
            i++;
        }
        int j = i;
        for (; j < r; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        return verifySequenceOfBST(sequence, l, i - 1) && verifySequenceOfBST(sequence, i, r - 1);
    }
}
