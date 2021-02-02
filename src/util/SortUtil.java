package util;

import java.io.IOException;

public class SortUtil {
    public static void main(String[] args) throws IOException {
        int[] test = new int[]{10, 5, 22, 15, 2, 52, 46, 23, 6, 1, 22};
        SortUtil.mergeSort(test);
        for (int e : test) {
            System.out.print(e + " ");
        }
        System.in.read();
    }

    public static void fastSort(int[] arr) {
        fastSort(arr, 0, arr.length - 1);
    }

    private static void fastSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int foundation = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[j] >= foundation) {
                j--;
            }
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            while (i < j && arr[i] <= foundation) {
                i++;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        fastSort(arr, start, i - 1);
        fastSort(arr, i + 1, end);
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;
        mergeSort(arr, start1, end1, temp);
        mergeSort(arr, start2, end2, temp);

        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            temp[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            temp[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            temp[k++] = arr[start2++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}
