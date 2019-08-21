package solution;

public class LeetCode67 {
	public static void main(String[] args) {
		LeetCode67 leetCode67 = new LeetCode67();
		System.out.print(leetCode67.addBinary("1010", "1011"));
	}

	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		String[] aArr = a.split("");
		String[] bArr = b.split("");
		int aLength = aArr.length;
		int bLength = bArr.length;
		int i = aLength - 1;
		int j = bLength - 1;
		boolean jinwei = false;
		String[] tmpResult = new String[1];
		while (i >= 0 && j >= 0) {
			jinwei = this.shouldjinwei(aArr[i], bArr[j], tmpResult, jinwei);
			result.append(tmpResult[0]);
			i--;
			j--;
		}
		if (i >= 0) {
			for (; i >= 0; i--) {
				jinwei = this.shouldjinwei(aArr[i], jinwei ? "1" : "0", tmpResult, false);
				result.append(tmpResult[0]);
			}
		} else if (j >= 0) {
			for (; j >= 0; j--) {
				jinwei = this.shouldjinwei(jinwei ? "1" : "0", bArr[j], tmpResult, false);
				result.append(tmpResult[0]);
			}
		}
		if (jinwei) {
			result.append("1");
		}
		return result.reverse().toString();
	}

	private boolean shouldjinwei(String n, String m, String[] result, boolean jinwei) {
		if (jinwei) {
			if (n.equals("0") && m.equals("0")) {
				result[0] = "1";
				return false;
			}
			if ((n.equals("1") && m.equals("0")) || (n.equals("0") && m.equals("1"))) {
				result[0] = "0";
				return true;
			}
			if (n.equals("1") && m.equals("1")) {
				result[0] = "1";
				return true;
			}
		} else {
			if (n.equals("0") && m.equals("0")) {
				result[0] = "0";
				return false;
			}
			if ((n.equals("1") && m.equals("0")) || (n.equals("0") && m.equals("1"))) {
				result[0] = "1";
				return false;
			}
			if (n.equals("1") && m.equals("1")) {
				result[0] = "0";
				return true;
			}
		}
		return false;
	}
}
