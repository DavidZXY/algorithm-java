package problem.print_matrix;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int [] a = new int[] {0, 1, 0, -1};
        int [] b = new int[] {1, 0, -1, 0};
        int turn = 0;
        boolean [][] temp = new boolean[matrix.length + 2][matrix[0].length + 2];
        int lenRow = temp.length;
        int lenCol = temp[0].length;
        for (int i = 0; i < lenCol; i++) {
            temp[0][i] = true;
            temp[lenRow - 1][i] = true;
        }
        for (int i = 1; i < lenRow - 1; i++) {
            temp[i][0] = true;
            temp[i][lenCol - 1] = true;
        }

        ArrayList<Integer> list = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = 0;
        while (list.size() < row * col) {
            list.add(matrix[i][j]);
            temp[i + 1][j + 1] = true;
            if (temp[i + 1 + a[turn]][j + 1 + b[turn]]) {
                turn = (turn + 1 ) % 4;
            }
            i += a[turn];
            j += b[turn];
        }

        return list;
    }
}
