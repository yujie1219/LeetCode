package solution;

import java.util.Stack;

public class LeetCode71 {
	public static void main(String[] args) {
		LeetCode71 leetCode71 = new LeetCode71();
		System.out.print(leetCode71.simplifyPath("/a//b////c/d//././/.."));
	}

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] pathArr = path.split("/");
		for (String item : pathArr) {
			if (item.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (item.equals(".") || item.equals("/") || item.equals("")) {
				continue;
			} else {
				stack.add(item);
			}
		}
		StringBuilder resultBuilder = new StringBuilder();
		if (stack.empty()) {
			resultBuilder.append("/");
		} else {
			stack.forEach(item -> {
				resultBuilder.append("/").append(item);
			});
		}

		return resultBuilder.toString();
	}
}
