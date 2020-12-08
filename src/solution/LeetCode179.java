package solution;

import java.util.List;

public class LeetCode179 {

    public static void main(String[] args) {
//        new LeetCode179().largestNumber(new int[]{4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398});
        //new LeetCode179().largestNumber(new int[]{121, 12});

        Integer value1 = 128;
        Integer value2 = 128;
        if( value1== value2){
            System.out.println("same");
        }else{
            System.out.println("not smae");
        }
    }

    public String largestNumber(int[] nums) {
        this.sort(nums);

        StringBuilder builder = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            builder.append(nums[i]);
        }

        String result = builder.toString();

        if (result.startsWith("0")) {
            result = Integer.valueOf(result).toString();
        }

        return result;
    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                int compareResult = compare(nums[j], nums[j + 1]);
                if (compareResult == 1) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    // if i > j ,return 1, if i== j ,return 0, if i<j return -1
    private int compare(int i, int j) {
        String n = i + "";
        String m = j + "";

        String nm = n + m;
        String mn = m + n;

        int k = 0;
        while (k < nm.length()) {
            if (Integer.valueOf(nm.charAt(k)) > Integer.valueOf(mn.charAt(k))) {
                return 1;
            } else if (Integer.valueOf(nm.charAt(k)) < Integer.valueOf(mn.charAt(k))) {
                return -1;
            }

            k++;
        }

        return 0;
    }
}
