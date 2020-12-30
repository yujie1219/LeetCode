package solution;

import model.QuadNode;

public class LeetCode427 {
    public QuadNode construct(int[][] grid) {
        int length = grid.length;
        int y = 0;
        int x = 0;
        int sameResult = isSame(grid, y, x, length);

        if (sameResult == 0) {
            return new QuadNode(false, true);
        } else if (sameResult == 1) {
            return new QuadNode(true, true);
        } else if (sameResult == 2) {
            length = length / 2;
            QuadNode topLeft = getNode(grid, y, x, length);
            QuadNode topRight = getNode(grid, y, x + length, length);
            QuadNode bottomLeft = getNode(grid, y + length, x, length);
            QuadNode bottomRight = getNode(grid, y + length, x + length, length);
            return new QuadNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }

        return null;
    }

    private QuadNode getNode(int[][] grid, int y, int x, int length) {
        int sameResult = isSame(grid, y, x, length);

        if (sameResult == 0) {
            return new QuadNode(false, true);
        } else if (sameResult == 1) {
            return new QuadNode(true, true);
        } else if (sameResult == 2) {
            length = length / 2;
            QuadNode topLeft = getNode(grid, y, x, length);
            QuadNode topRight = getNode(grid, y, x + length, length);
            QuadNode bottomLeft = getNode(grid, y + length, x, length);
            QuadNode bottomRight = getNode(grid, y + length, x + length, length);
            return new QuadNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }

        return null;
    }

    // return 0 -> All 0; 1 -> All 1; 2 -> Has 0 and 1
    private int isSame(int[][] grid, int y, int x, int length) {
        boolean hasOne = false;
        boolean hasZero = false;

        for (int i = y; i < y + length; i++) {
            for (int j = x; j < x + length; j++) {
                if (grid[i][j] == 1) {
                    hasOne = true;
                } else if (grid[i][j] == 0) {
                    hasZero = true;
                }

                if (hasOne && hasZero) {
                    return 2;
                }
            }
        }

        if (hasOne) {
            return 1;
        }

        if (hasZero) {
            return 0;
        }

        return  3;
    }
}
