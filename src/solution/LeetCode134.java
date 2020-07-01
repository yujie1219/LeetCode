package solution;

public class LeetCode134 {

    public static void main(String[] args) {
        LeetCode134 leetCode134 = new LeetCode134();
        leetCode134.canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1});
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
//                if (startASC(gas, cost, i) || startDEC(gas, cost, i)) {
//                    return i;
//                }
                if (startASC(gas, cost, i)) {
                    return i;
                }
            }
        }

        return -1;
    }

    private boolean startASC(int[] gas, int[] cost, int start) {
        int remainGas = gas[start];
        int current = start;
        int target = start == gas.length - 1 ? 0 : start + 1;

        while (target != start) {
            if (!toNext(cost, current, remainGas)) {
                return false;
            }

            remainGas = remainGas - cost[current] + gas[target];
            current = target;
            target = target == gas.length - 1 ? 0 : target + 1;
        }

        return toNext(cost, current, remainGas);
    }

    private boolean startDEC(int[] gas, int[] cost, int start) {
        int remainGas = gas[start];
        int current = start;
        int target = start == 0 ? gas.length - 1 : start - 1;

        while (target != start) {
            if (!toNext(cost, target, remainGas)) {
                return false;
            }

            remainGas = remainGas - cost[target] + gas[target];
            current = target;
            target = target == 0 ? gas.length - 1 : target - 1;
        }

        return toNext(cost, target, remainGas);
    }

    private boolean toNext(int[] cost, int current, int remain) {
        return remain - cost[current] >= 0;
    }
}
