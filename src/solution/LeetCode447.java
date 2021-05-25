package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode447 {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, List<Integer>> distance2Index = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int distance = distance(points[i], points[j]);

                if (!distance2Index.containsKey(distance)) {
                    distance2Index.put(distance, new ArrayList<>());
                }

                List<Integer> list = distance2Index.get(distance);
                list.add(j);
            }

            for (Integer key : distance2Index.keySet()) {
                int size = distance2Index.get(key).stream().distinct().collect(Collectors.toList()).size();
                if (size >= 2) {
                    result += size * (size - 1);
                }
            }

            distance2Index.clear();
        }

        return result;
    }

    private int distance(int[] x, int[] y) {
        return (int) (Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }
}
