package sort.quick;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        quick_sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void quick_sort(int[] arr, int left, int right) {
        int low = left;
        int high = right;

        int mid = (low + high) / 2;
        int pivot = arr[mid];

        while (low <= high) {
            while (arr[low] <= pivot) {
                low++;
            }

            while (pivot <= arr[high]) {
                high--;
            }


            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }


        if (low < right) {
            quick_sort(arr, low, right);
        }

        if (left < high) {
            quick_sort(arr, left, high);
        }
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
