package solution;

import model.NodeTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode116 {

    public NodeTwo connect(NodeTwo root) {
        if (root == null) {
            return root;
        }

        Map<Integer, List<NodeTwo>> bFSMap = new HashMap<>();

        bfs(root, 0, bFSMap);

        for (List<NodeTwo> currentFloor : bFSMap.values()) {
            for (int i = 0; i < currentFloor.size() - 1; i++) {
                currentFloor.get(i).next = currentFloor.get(i + 1);
            }
            currentFloor.get(currentFloor.size() - 1).next = null;
        }

        return root;
    }

    private void bfs(NodeTwo current, int level, Map<Integer, List<NodeTwo>> bFSMap) {
        if (!bFSMap.containsKey(level)) {
            bFSMap.put(level, new ArrayList<>());
        }

        List<NodeTwo> currentFloor = bFSMap.get(level);
        currentFloor.add(current);

        if (current.left != null && current.right != null) {
            bfs(current.left, level + 1, bFSMap);
            bfs(current.right, level + 1, bFSMap);
        }
    }
}
