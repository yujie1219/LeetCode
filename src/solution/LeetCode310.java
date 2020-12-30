package solution;

import model.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode310 {
    public static void main(String[] args) {
        new LeetCode310().findMinHeightTrees(10, new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 4}, {0, 5}, {5, 6}, {6, 7}, {2, 8}, {7, 9}});
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        Map<Integer, List<Integer>> relationShip = getRelationShip(edges);
        int currentMinHeight = Integer.MAX_VALUE;
        int[] triedRoot = new int[n];

        for (int i = 0; i < n/2+1; i++) {
            Integer currentRoot = findRoot(relationShip, triedRoot);
            if (currentRoot != -1) {
                Node root = new Node(currentRoot);
                createTreeWithRoot(root, relationShip, new int[n]);
                int current = getHeight(root);

                if (current < currentMinHeight) {
                    result.clear();
                    result.add(currentRoot);
                    currentMinHeight = current;
                } else if (current == currentMinHeight) {
                    result.add(currentRoot);
                }
            }
        }

        return result;
    }

    public int getHeight(Node current) {
        if (current.neighbors.size() == 0) {
            return 1;
        }

        int currentHeight = Integer.MIN_VALUE;
        for (Node neighbor : current.neighbors) {
            int height = getHeight(neighbor);

            if (currentHeight < height) {
                currentHeight = height;
            }
        }

        return currentHeight + 1;
    }

    public int findRoot(Map<Integer, List<Integer>> relationShip, int[] triedRoot) {
        int maxRelationShip = Integer.MIN_VALUE;
        int currentRoot = -1;

        for (Integer root : relationShip.keySet()) {
            int relationShips = relationShip.get(root).size();
            if (triedRoot[root] != 1 && relationShips >= maxRelationShip) {
                maxRelationShip = relationShips;
                currentRoot = root;
            }
        }

        if (currentRoot != -1) {
            triedRoot[currentRoot] = 1;
        }
        return currentRoot;
    }

    public void createTreeWithRoot(Node current, Map<Integer, List<Integer>> relationShip, int[] used) {
        List<Integer> children = relationShip.get(current.val);
        used[current.val] = 1;

        if (children != null) {
            for (Integer nodeVal : children) {
                if (used[nodeVal] != 1) {
                    current.neighbors.add(new Node(nodeVal));
                }
            }

            for (Node neighbor : current.neighbors) {
                createTreeWithRoot(neighbor, relationShip, used);
            }
        }
    }

    private Map<Integer, List<Integer>> getRelationShip(int[][] edges) {
        Map<Integer, List<Integer>> relationShip = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            if (!relationShip.containsKey(a)) {
                relationShip.put(a, new ArrayList<>());
            }
            if (!relationShip.containsKey(b)) {
                relationShip.put(b, new ArrayList<>());
            }

            relationShip.get(a).add(b);
            relationShip.get(b).add(a);
        }

        return relationShip;
    }
}
