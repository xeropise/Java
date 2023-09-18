package sort.insertion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = { 6, 4, 3, 7, 1, 9, 8};

        int[] sortedArr = insertionSort(arr.clone());

        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];

            int j = (i-1);

            while(j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = target;
        }
        return arr;
    }
}
