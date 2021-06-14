package Interview;

public class FindTarget {

    public static void main(String[] args) {
        System.out.println(new FindTarget().findTarget(new int[][]{{1,3,4,6},{2,5,7,8}}, 3));
    }

    public boolean findTarget(int[][] martix, int target) {
        if (martix == null || martix.length == 0 || martix[0].length == 0) {
            return false;
        }

        int n = martix.length - 1;
        int m = martix[0].length - 1;
        if (target < martix[0][0] || target > martix[n][m]) {
            return false;
        }

        return findFromRightTop(martix, 0, m, target);
    }

    private boolean findFromRightTop(int[][] martix, int y, int x, int target) {
//        if (x < 0 || y >= martix.length) {
//            return false;
//        }
//
//        if (martix[y][x] < target) {
//            return findFromRightTop(martix, y + 1, x, target);
//        } else if (martix[y][x] == target) {
//            return true;
//        } else {
//            return findFromRightTop(martix, y, x - 1, target);
//        }

        int n = martix.length;
        while (x >= 0 && y < n) {
            if (martix[y][x] < target) {
                y++;
            } else if (martix[y][x] == target) {
                return true;
            } else {
                x--;
            }
        }

        return false;
    }
}
