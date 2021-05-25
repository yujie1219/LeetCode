package solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCode475 {
    public static void main(String[] args) throws IOException {
        BufferedReader testHouses = new BufferedReader(new FileReader("D:\\workspace\\LeetCode\\src\\testData\\LeetCode475Houses.txt"));
        BufferedReader testHeaters = new BufferedReader(new FileReader("D:\\workspace\\LeetCode\\src\\testData\\LeetCode475Heaters.txt"));

        StringBuilder stringBuilder = new StringBuilder();
        String line = testHouses.readLine();
        while (line != null) {
            stringBuilder.append(line);
            line = testHouses.readLine();
        }

        int[] houses = Arrays.stream(stringBuilder.toString().split(",")).mapToInt(item -> Integer.parseInt(item)).toArray();

        stringBuilder = new StringBuilder();
        line = testHeaters.readLine();
        while (line != null) {
            stringBuilder.append(line);
            line = testHeaters.readLine();
        }

        int[] heaters = Arrays.stream(stringBuilder.toString().split(",")).mapToInt(item -> Integer.parseInt(item)).toArray();

        System.out.println(new LeetCode475().findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        int result = 0;
        Arrays.sort(heaters);

        for (int i = 0; i < houses.length; i++) {
            int currentResult = Integer.MAX_VALUE;
            int currentHouse = houses[i];

            for (int j = 0; j < heaters.length; j++) {
                int distance = Math.abs(heaters[j] - currentHouse);

                if (distance <= currentResult) {
                    currentResult = distance;
                } else {
                    break;
                }
            }
            result = Math.max(result, currentResult);
        }

        return result;
    }
}
