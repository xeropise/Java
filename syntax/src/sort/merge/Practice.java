package sort.merge;

import java.util.Arrays;

class Practice {

    static int[] newArr;

    public static void main(String[] args) {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        newArr = new int[arr.length];

        merge_sort(arr, 0, arr.length -1);

        System.out.println(Arrays.toString(newArr));
    }

    static void merge_sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);

        merge_sort(arr, left, mid, right);
    }

    static void merge_sort(int[] arr, int left, int mid, int right) {
        int start = left;
        int end = (mid + 1);
        int idx = left;

        while (start <= mid && end <= right) {
            if (arr[start] <= arr[end]) {
                newArr[idx] = arr[start];
                idx++;
                start++;
            } else {
                newArr[idx] = arr[end];
                idx++;
                end++;
            }
        }

        if (start > mid) {
            while (end <= end) {
                newArr[idx] = arr[end];
                idx++;
                end++;
            }
        } else {
            while (start <= mid) {
                newArr[idx] = arr[start];
                idx++;
                start++;
            }
        }


        for (int i = left; i <= right; i++) {
            arr[i] = newArr[i];
        }
    }
}