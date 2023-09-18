package sort.selection;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        int[] arr = { 6, 4, 3, 7, 1, 9, 8};

        int[] sortedArr = selectionSort(arr.clone());

        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            int minIndex = i;

            // 최소값을 찾음
            for (int j = (i+1); j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 최소값을 맨 앞 자리와 교환한다.
            swap(arr, minIndex, i);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
