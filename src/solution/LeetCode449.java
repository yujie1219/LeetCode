package solution;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();

            if (root != null) {
                Queue<TreeNode> nodes = new LinkedList<>();
                nodes.offer(root);

                while (!nodes.isEmpty()) {
                    TreeNode node = nodes.poll();

                    if (node != null) {
                        stringBuilder.append(node.val + ",");
                        nodes.offer(node.left);
                        nodes.offer(node.right);
                    } else {
                        stringBuilder.append("null,");
                    }
                }

                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            }

            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) {
                return null;
            }

            String[] nodeValues = data.split(",");

            int i = 0;
            TreeNode root = new TreeNode(Integer.parseInt(nodeValues[i++]));
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.offer(root);
            while (i < nodeValues.length) {
                TreeNode parent = nodes.poll();
                String left = nodeValues[i++];

                if (!left.equals("null")) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    nodes.offer(parent.left);
                }

                if (i >= nodeValues.length) {
                    break;
                }

                String right = nodeValues[i++];
                if (!right.equals("null")) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    nodes.offer(parent.right);
                }
            }

            return root;
        }
    }
}
