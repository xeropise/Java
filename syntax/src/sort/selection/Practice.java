package sort.selection;

import java.util.Arrays;

public class Practice {

    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {

        int[] copiedArr = Arrays.copyOf(arr, arr.length);
        selection_sort(copiedArr);

        System.out.println(Arrays.toString(copiedArr));
    }


    static void selection_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = (i+1); j < arr.length; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
