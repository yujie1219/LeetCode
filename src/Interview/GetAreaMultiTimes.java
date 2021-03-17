package Interview;

public class GetAreaMultiTimes {
    public int getValue(int[][] nums, int x1, int y1, int x2, int y2) {
        if (nums.length == 0) {
            return 0;
        }

        int[][] cache = new int[nums.length][nums[0].length];
        init(nums, cache);

        int result = nums[0][0];
        int maxX = Math.max(x1, x2);
        int maxY = Math.max(y1, y2);

        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);

        if (minX == 0) {
            int minus2 = nums[maxX][minY - 1];
            result += nums[maxX][maxY] - minus2;
        } else if (minY == 0) {
            int minus1 = nums[minX - 1][y1];
            result += nums[maxX][maxY] - minus1;
        } else {
            int minus1 = nums[minX - 1][y1];
            int minus2 = nums[maxX][minY - 1];
            result += nums[maxX][maxY] - minus1 - minus2;
        }

        return result;
    }

    private void init(int[][] nums, int[][] cache) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int currentJ = j;
                int temp = 0;
                while (currentJ >= 0) {
                    temp += nums[i][currentJ];
                    currentJ--;
                }

                if (i != 0) {
                    temp += cache[i - 1][j];
                }

                cache[i][j] = temp;
            }
        }
    }
}
