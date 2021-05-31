package solution;

public class LeetCode529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        int m = board.length;
        int n = board[0].length;

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (board[x][y] == 'E') {
            int MNum = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int tempX = x + i;
                    int tempY = y + j;
                    if ((i != 0 || j != 0) && tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && board[tempX][tempY] == 'M') {
                        MNum++;
                    }
                }
            }

            if (MNum != 0) {
                board[x][y] = (char) (MNum + '0');
            } else {
                board[x][y] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        int tempX = x + i;
                        int tempY = y + j;
                        if ((i != 0 || j != 0) && tempX >= 0 && tempX < m && tempY >= 0 && tempY < n) {
                            int[] currentClick = new int[2];
                            currentClick[0] = tempX;
                            currentClick[1] = tempY;
                            updateBoard(board, currentClick);
                        }
                    }
                }
            }
        }

        return board;
    }
}
