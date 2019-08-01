package solution;

import java.util.Stack;

public class LeetCode32 {
	public static void main(String[] args) {
		LeetCode32 leetCode32 = new LeetCode32();
		System.out.println(leetCode32.longestValidParentheses("(()"));
	}

	// Timeout
	public int longestValidParentheses(String s) {
		int max = 0;
		boolean hasRight = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')') {
				hasRight = true;
				break;
			}
		}
		if (!hasRight) {
			return max;
		}
		for (int i = 0; i < s.length(); i++) {
			Stack<Character> stack = new Stack<Character>();
			int tmpMax = 0;
			for (int j = i + 1; j < s.length(); j += 2) {
				if (s.charAt(j - 1) == '(') {
					if (s.charAt(j) == '(') {
						stack.push('(');
						stack.push('(');
					} else {
						tmpMax += 2;
						if (stack.empty())
							max = max > tmpMax ? max : tmpMax;
					}
				} else {
					if (!stack.empty()) {
						stack.pop();
						tmpMax += 2;
						if (stack.empty())
							max = max > tmpMax ? max : tmpMax;
						if (s.charAt(j) == '(') {
							stack.push('(');
						} else {
							if (!stack.empty()) {
								stack.pop();
								tmpMax += 2;
								if (stack.empty())
									max = max > tmpMax ? max : tmpMax;
							}
						}
					} else {
						break;
					}
				}
			}
			if (stack.empty())
				max = max > tmpMax ? max : tmpMax;
		}
		return max;
	}

	// error
	public int longestValidParenthesesError(String s) {
		if (s.isEmpty()) {
			return 0;
		} else {
			String[] sArr = s.split("");
			int start = 0;
			int end = s.length() - 1;
			while (!sArr[start].equals("(") && start + 1 < end) {
				start++;
			}
			while (!sArr[end].equals(")") && end - 1 > start) {
				end--;
			}
			if (start >= end) {
				return 0;
			}
			String ss = s.substring(start, end + 1);
			String[] ssArr = ss.split("");
			start = 0;
			end = ss.length() - 1;
			int max = 0;
			while (start < end) {
				int i = start;
				int leftNumber = 0;
				int tmpLength = 0;
				for (; i <= end; i++) {
					if (i + 1 < end) {
						if (ssArr[i].equals("(")) {
							if (ssArr[i + 1].equals(")")) {
								tmpLength += 2;
								i++;
							} else {
								leftNumber++;
							}
						} else {
							if (leftNumber == 0) {
								start = i + 1;
								break;
							} else {
								leftNumber--;
								tmpLength++;
							}
						}
					} else if (i + 1 == end) {
						start = i + 1;
						if (ssArr[i].equals("(")) {
							tmpLength += 2;
						} else {
							if (leftNumber >= 2) {
								tmpLength += 4;
							} else {
								tmpLength += leftNumber * 2;
							}
						}
						break;
					} else if (i == end) {
						start = i;
						if (leftNumber >= 1) {
							tmpLength += 2;
						}
					}
				}

				if (tmpLength > max) {
					max = tmpLength;
				}
			}
			return max;
		}
	}
}
