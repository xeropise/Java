package sort.quick;

import java.util.Arrays;

public class Main {
    private static int[] arr = {8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int [] arr, int left, int right) {
        int low = left;
        int high = right;

        int pivot = arr[(left + right) / 2];

        while(low <= high) {
            while(arr[low] < pivot) {
                low++;
            }

            while(arr[high] > pivot) {
                high--;
            }

            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        if (low < right) {
            quickSort(arr, low, right);
        }

        if (left < high) {
            quickSort(arr, left, high);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
