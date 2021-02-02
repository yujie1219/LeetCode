package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> parent2Children = new HashMap<>();
        Map<Integer, Boolean> hasCycle = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][0];
            if (!parent2Children.containsKey(key)) {
                parent2Children.put(key, new ArrayList<>());
            }

            parent2Children.get(key).add(prerequisites[i][1]);
        }

        List<Integer> used = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            used.add(i);
            if (hasCycle(parent2Children, used, i, hasCycle)) {
                return false;
            }
            used.remove(used.size() - 1);
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> parent2Children, List<Integer> used, int currentCourse, Map<Integer, Boolean> hasCycle) {
        if (hasCycle.containsKey(currentCourse)) {
            return hasCycle.get(currentCourse);
        }

        if (!parent2Children.containsKey(currentCourse)) {
            return false;
        }

        List<Integer> children = parent2Children.get(currentCourse);
        for (Integer child : children) {
            if (used.contains(child)) {
                hasCycle.put(currentCourse, true);
                return true;
            }
        }

        for (Integer child : children) {
            used.add(child);
            if (hasCycle(parent2Children, used, child, hasCycle)) {
                return true;
            }
            used.remove(used.size() - 1);
        }

        hasCycle.put(currentCourse, false);
        return false;
    }
}
