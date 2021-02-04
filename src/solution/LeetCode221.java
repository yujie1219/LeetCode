package solution;

public class LeetCode221 {
    public static void main(String[] args) {
        char[][] test = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        new LeetCode221().maximalSquare(test);
    }

    public int maximalSquare(char[][] matrix) {
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int tempResult = 0;
                if (matrix[i][j] == '1') {
                    tempResult = 1;
                    boolean satisfy = true;

                    while (satisfy && i + tempResult < matrix.length && j + tempResult < matrix[i].length) {
                        for (int k = i; k <= i + tempResult; k++) {
                            for (int t = j; t <= j + tempResult; t++) {
                                if (matrix[k][t] == '0') {
                                    satisfy = false;
                                    break;
                                }
                            }

                            if(!satisfy){
                                break;
                            }
                        }

                        if (satisfy) {
                            tempResult++;
                        }
                    }
                }

                if (tempResult > result) {
                    result = tempResult;
                }
            }
        }

        return result * result;
    }
}
