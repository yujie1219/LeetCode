package solution;

import java.util.ArrayList;
import java.util.List;

public class LeetCode43 {
	public static void main(String[] args) {
		LeetCode43 leetCode43 = new LeetCode43();
		System.out.print(leetCode43.multiply("123456789", "987654321"));
	}

	// timeout
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		if (num1.equals("1")) {
			return num2;
		}
		if (num2.equals("1")) {
			return num1;
		}
		List<String> multiplicationResult = multiplicationResult(num1.split(""), num2.split(""));
		String tmpResult = "0";
		for (String result : multiplicationResult) {
			tmpResult = addResult(tmpResult, result);
		}
		return tmpResult;
	}

	private String addResult(String result, String num) {
		String shorter = result.length() > num.length() ? num : result;
		String longer = result.length() > num.length() ? result : num;
		int i = shorter.length() - 1;
		int j = longer.length() - 1;
		String tmpResult = "";
		int jinwei = 0;
		while (i >= 0) {
			int tmp = Integer.parseInt(shorter.charAt(i) + "") + Integer.parseInt(longer.charAt(j) + "");
			if (jinwei == 0) {
				tmpResult = tmp % 10 + tmpResult;
				jinwei = tmp / 10;
			} else {
				if (tmp != 9) {
					tmpResult = tmp % 10 + 1 + tmpResult;
					jinwei = tmp / 10;
				} else {
					tmpResult = "0" + tmpResult;
					jinwei = 1;
				}
			}
			i--;
			j--;
		}
		if (j != -1) {
			String remain = longer.substring(0, j + 1);
			if (jinwei == 0) {
				tmpResult = remain + tmpResult;
			} else {
				remain = addResult(remain, "1");
				tmpResult = remain + tmpResult;
			}
		} else {
			if (jinwei == 1) {
				tmpResult = "1" + tmpResult;
			}
		}
		return tmpResult;
	}

	private List<String> multiplicationResult(String[] num1, String[] num2) {
		int num1Length = num1.length;
		int num2Length = num2.length;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < num1Length; i++) {
			if (num1[i].equals("0")) {
				continue;
			}
			for (int j = 0; j < num2Length; j++) {
				if (num2[j].equals("0")) {
					continue;
				}
				String tmpResult = (Integer.parseInt(num1[i]) * Integer.parseInt(num2[j])) + "";
				for (int k = 1; k <= ((num1Length - 1 - i) + (num2Length - 1 - j)); k++) {
					tmpResult += "0";
				}
				result.add(tmpResult);
			}
		}
		return result;
	}
}
