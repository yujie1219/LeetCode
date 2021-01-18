package solution;

import java.util.Map;

public class LeetCode1232 {
    public static void main(String[] args) {
        new LeetCode1232().checkStraightLine(new int[][]{{2, 1}, {4, 2}, {6, 3}});
    }


    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        boolean isX = false;
        if (x1 == x2) {
            isX = true;
        }

        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        boolean isY = false;
        if (y1 == y2) {
            isY = true;
        }

        if (isX) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != x1) {
                    return false;
                }
            }
        } else if (isY) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != y1) {
                    return false;
                }
            }

        } else {
            double k = findK(x1, y1, x2, y2);
            double b = findB(x1, y1, k);

            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][1] != (k * coordinates[i][0]) + b) {
                    return false;
                }
            }
        }

        return true;
    }

    private double findK(int x1, int y1, int x2, int y2) {
        if (x1 == 0 && x2 == 0) {
            return 0;
        }

        return ((double) (y2 - y1)) / ((double) (x2 - x1));
    }

    private double findB(int x, int y, double k) {
        return y - k * x;
    }
}
