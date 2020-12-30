package solution;

import model.BinaryNodeWithNext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode116 {

    public BinaryNodeWithNext connect(BinaryNodeWithNext root) {
        if (root == null) {
            return root;
        }

        Map<Integer, List<BinaryNodeWithNext>> bFSMap = new HashMap<>();

        bfs(root, 0, bFSMap);

        for (List<BinaryNodeWithNext> currentFloor : bFSMap.values()) {
            for (int i = 0; i < currentFloor.size() - 1; i++) {
                currentFloor.get(i).next = currentFloor.get(i + 1);
            }
            currentFloor.get(currentFloor.size() - 1).next = null;
        }

        return root;
    }

    private void bfs(BinaryNodeWithNext current, int level, Map<Integer, List<BinaryNodeWithNext>> bFSMap) {
        if (!bFSMap.containsKey(level)) {
            bFSMap.put(level, new ArrayList<>());
        }

        List<BinaryNodeWithNext> currentFloor = bFSMap.get(level);
        currentFloor.add(current);

        if (current.left != null && current.right != null) {
            bfs(current.left, level + 1, bFSMap);
            bfs(current.right, level + 1, bFSMap);
        }
    }
}
