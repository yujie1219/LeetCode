package solution;

import model.NodeTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode117 {

    private Map<Integer, List<NodeTwo>> levelSearch = new HashMap<>();

    public NodeTwo connect(NodeTwo root) {
        if (root != null) {
            df(0, root);
            toNext();
        }

        return root;
    }

    private void df(int level, NodeTwo current) {
        if (current == null) {
            return;
        }

        List<NodeTwo> list = levelSearch.get(level);
        if (list != null) {
            list.add(current);
        } else {
            list = new ArrayList<>();
            list.add(current);
            levelSearch.put(level, list);
        }

        df(level + 1, current.left);
        df(level + 1, current.right);
    }

    private void toNext() {
        for (List<NodeTwo> list : levelSearch.values()) {
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
    }
}
