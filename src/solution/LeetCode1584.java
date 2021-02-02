package solution;

public class LeetCode1584 {
    public static void main(String[] args) {
        new LeetCode1584().minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});
    }

    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        int[][] distances = new int[length][length];
        int[] used = new int[length];
        used[0] = 1;
        int consume = 0;

        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            initDistances(points, distances, currentIndex);
        }

        int usedLength = 1;
        while (usedLength < length) {
            consume += getClosestConsume(distances, used);
            usedLength++;
        }

        return consume;
    }

    private void initDistances(int[][] points, int[][] distances, int currentIndex) {
        for (int i = 0; i < points.length; i++) {
            if (i != currentIndex && distances[currentIndex][i] == 0) {
                int distance = Math.abs(points[currentIndex][0] - points[i][0]) + Math.abs(points[currentIndex][1] - points[i][1]);
                distances[currentIndex][i] = distance;
                distances[i][currentIndex] = distance;
            }
        }
    }

    private int getClosestConsume(int[][] distances, int[] used) {
        int closestDistance = -1;
        int closestPoint = 0;

        for (int existedPoint = 0; existedPoint < used.length; existedPoint++) {
            if (used[existedPoint] == 1) {
                int currentClosestIndex = existedPoint;

                for (int currentIndex = 0; currentIndex < distances[existedPoint].length; currentIndex++) {
                    if (used[currentIndex] == 0 && currentIndex != existedPoint && (currentClosestIndex == existedPoint || distances[existedPoint][currentIndex] < distances[existedPoint][currentClosestIndex])) {
                        currentClosestIndex = currentIndex;
                    }
                }

                if (closestDistance == -1 || closestDistance > distances[currentClosestIndex][existedPoint]) {
                    closestPoint = currentClosestIndex;
                    closestDistance = distances[currentClosestIndex][existedPoint];
                }
            }
        }

        used[closestPoint] = 1;
        return closestDistance;
    }
}
