package solution;

import java.util.*;

public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> child2Parent = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            if (!child2Parent.containsKey(key)) {
                child2Parent.put(key, new ArrayList<>());
            }

            child2Parent.get(key).add(prerequisite[1]);
        }

        Queue<Integer> sort = new LinkedList<>();
        // 0 - not visited  1 - visiting 2 - visited
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (DFS(i, child2Parent, visited, sort)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        int i = 0;
        while (!sort.isEmpty()) {
            result[i++] = sort.poll();
        }

        return result;
    }

    // return true - has cycle false - not cycle
    private boolean DFS(int currentCourse, Map<Integer, List<Integer>> child2Parent, int[] visited, Queue<Integer> sort) {
        if (visited[currentCourse] == 2) {
            return false;
        }

        visited[currentCourse] = 1;
        if (child2Parent.containsKey(currentCourse)) {
            List<Integer> parents = child2Parent.get(currentCourse);
            for (Integer parent : parents) {
                if (visited[parent] == 1) {
                    return true;
                }

                if(DFS(parent, child2Parent, visited, sort)){
                    return true;
                }
            }
        }

        visited[currentCourse] = 2;
        sort.offer(currentCourse);
        return false;
    }
}
