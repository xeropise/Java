package sort.insertion;

import java.util.Arrays;

public class Practice {
    static int[] arr = {5, 1, 3, 7, 2, 9};

    public static void main(String[] args) {
        int[] copiedArr = Arrays.copyOf(arr, arr.length);

        insertion_sort(copiedArr);

        System.out.println(Arrays.toString(copiedArr));
    }

    static void insertion_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];

            int j = (i-1);

            while(j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = target;

        }
    }
}
