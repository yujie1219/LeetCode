package solution;

public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;

        return findCombination(numbers, index1, index2, target);
    }

    private int[] findCombination(int[] numbers, int index1, int index2, int target) {
        if (index1 >= index2) {
            return null;
        }

        if (numbers[index1] + numbers[index2] == target) {
            return new int[]{index1 + 1, index2 + 1};
        }

        if (numbers[index2] > target) {
            return findCombination(numbers, index1, index2 - 1, target);
        }

        if (numbers[index1] + numbers[index2] > target) {
            return findCombination(numbers, index1, index2 - 1, target);
        } else {
            return findCombination(numbers, index1 + 1, index2, target);
        }
    }
}
