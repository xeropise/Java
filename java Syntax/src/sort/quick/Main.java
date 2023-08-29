package sort.quick;

import java.util.Arrays;

public class Main {
    private static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int [] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[right];

        int sortedIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, sortedIndex);
                sortedIndex++;
            }
        }

        swap(arr, sortedIndex, right);
        quickSort(arr, left, sortedIndex - 1);
        quickSort(arr, sortedIndex + 1, right);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
