package solution;

import model.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode133 {

    public Node cloneGraph(Node node) {
        return node == null? null : cloneNode(node, new HashMap<Node, Node>());
    }

    private Node cloneNode(Node current, Map passed) {
        if (passed.keySet().contains(current)) {
            return (Node) passed.get(current);
        }

        Node result = new Node(current.val);
        passed.put(current, result);

        for (Node node : current.neighbors) {
            result.neighbors.add(cloneNode(node, passed));
        }

        return result;
    }
}
