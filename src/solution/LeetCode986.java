package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Queue<List<Integer>> resultBeforeMerge = new LinkedList<>();

        for (int i = 0; i < firstList.length; i++) {
            for (int j = 0; j < secondList.length; j++) {
                if (firstList[i][0] > secondList[j][1]) {
                    continue;
                } else if (firstList[i][1] < secondList[j][0]) {
                    break;
                } else {
                    List<Integer> splitResult = new ArrayList<>();
                    if (firstList[i][0] >= secondList[j][0] && firstList[i][1] <= secondList[j][1]) {
                        splitResult.add(firstList[i][0]);
                        splitResult.add(firstList[i][1]);
                    } else if (firstList[i][0] >= secondList[j][0]) {
                        splitResult.add(firstList[i][0]);
                        splitResult.add(secondList[j][1]);
                    } else if (firstList[i][1] <= secondList[j][1]) {
                        splitResult.add(secondList[j][0]);
                        splitResult.add(firstList[i][1]);
                    } else if (firstList[i][0] <= secondList[j][0] && firstList[i][1] >= secondList[j][1]) {
                        splitResult.add(secondList[j][0]);
                        splitResult.add(secondList[j][1]);
                    }
                    resultBeforeMerge.add(splitResult);
                }
            }
        }

        int[][] result = new int[resultBeforeMerge.size()][2];
        int i = 0;
        while (!resultBeforeMerge.isEmpty()) {
            List<Integer> temp = resultBeforeMerge.poll();
            result[i][0] = temp.get(0);
            result[i][1] = temp.get(1);
            i++;
        }

        return result;
    }
}
