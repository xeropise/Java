package sort.bubble;

import java.util.Arrays;

public class Practice {

    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        int[] copiedArr = Arrays.copyOf(arr, arr.length);

        bubble_sort(copiedArr);

        System.out.println(Arrays.toString(copiedArr));
    }

    static void bubble_sort(int[] arr) {
        bubble_sort(arr, arr.length - 1);
    }

    static void bubble_sort(int[] arr, int last) {
        if (last > 0) {
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
            }

            bubble_sort(arr, last - 1);
        }

    }

    static void swap(int[] arr, int source, int target) {
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }
}
