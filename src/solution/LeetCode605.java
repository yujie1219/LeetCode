package solution;

public class LeetCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        if (length == 1) {
            if (flowerbed[0] == 1 && n != 0) {
                return false;
            }

            if (flowerbed[0] == 0 && n > 1) {
                return false;
            }

            return true;
        }

        if (n <= (length / 2 + 1)) {

            int result = 0;

            int i = 0;
            int parent = flowerbed[0];

            while (i < flowerbed.length) {
                if (i == 0) {
                    if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                        result++;
                        flowerbed[i] = 1;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i] == 0 && parent == 0) {
                        result++;
                        flowerbed[i] = 1;
                    }
                } else {
                    if (flowerbed[i] == 0 && parent == 0 && flowerbed[i + 1] == 0) {
                        result++;
                        flowerbed[i] = 1;
                    }
                }

                parent = flowerbed[i];
                i++;
            }

            return result >= n;
        } else {
            return false;
        }
    }
}
