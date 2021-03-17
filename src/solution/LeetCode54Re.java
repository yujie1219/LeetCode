package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54Re {
    public List<Integer> spiralOrder(int[][] matrix) {
        int topBorder = 0;
        int bottomBorder = matrix.length - 1;
        int leftBorder = 0;
        int rightBorder = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            while (j <= rightBorder) {
                result.add(matrix[i][j++]);
            }
            topBorder++;
            i++;
            j--;
            if (i > bottomBorder) {
                break;
            }

            while (i <= bottomBorder) {
                result.add(matrix[i++][j]);
            }
            rightBorder--;
            i--;
            j--;
            if (j < leftBorder) {
                break;
            }

            while (j >= leftBorder) {
                result.add(matrix[i][j--]);
            }
            bottomBorder--;
            i--;
            j++;
            if (i < topBorder) {
                break;
            }

            while (i >= topBorder) {
                result.add(matrix[i--][j]);
            }
            leftBorder++;
            i++;
            j++;
            if (j > rightBorder) {
                break;
            }
        }

        return result;
    }
}
