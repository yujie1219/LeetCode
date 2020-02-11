package solution;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class LeetCode100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		List<Integer> pVal = new ArrayList<Integer>();
		foreachTree(p, pVal);
		List<Integer> qVal = new ArrayList<Integer>();
		foreachTree(q, qVal);

		if (pVal.size() != qVal.size()) {
			return false;
		}
		for (int i = 0; i < pVal.size(); i++) {
			if (pVal.get(i) == null && qVal.get(i) == null) {
				continue;
			} else {
				if (pVal.get(i) != null && !pVal.get(i).equals(qVal.get(i))) {
					return false;
				}
				if (qVal.get(i) != null && !qVal.get(i).equals(pVal.get(i))) {
					return false;
				}
			}
		}

		return true;
	}

	private void foreachTree(TreeNode root, List<Integer> treeVal) {
		if (root != null) {
			treeVal.add(root.val);
			foreachTree(root.left, treeVal);
			foreachTree(root.right, treeVal);
		} else {
			treeVal.add(null);
		}
	}
}
