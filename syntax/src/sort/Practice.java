package sort;

import java.util.Arrays;

public class Practice {

    static int[] new_arr;
    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static void main(String[] args) {

        heap_sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
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

    static void selection_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = (i+1); j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    swap(arr, i, j);
                }
            }
        }
    }

    static void shell_sort(int[] arr) {
        for (int h = arr.length / 2; h > 0; h /= 2){
            for (int i = h; i < arr.length; i++) {
                int target = arr[i];
                int prev = (i - h);

                while (prev >= 0 && arr[prev] > target) {
                    arr[prev + h] = arr[prev];
                    prev -= h;
                }

                arr[prev + h] = target;
            }
        }
    }

    static void insertion_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = (i - 1);

            while (j >= 0 && arr[j] > target) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = target;
        }
    }

    static void merge_sort(int[] arr) {
        merge_sort(arr, 0, arr.length - 1);
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
                new_arr[idx] = arr[start];
                start++;
                idx++;
            } else {
                new_arr[idx] = arr[end];
                end++;
                idx++;
            }
        }

        if (start > mid) {
            while (end <= right) {
                new_arr[idx] = arr[end];
                end++;
                idx++;
            }
        } else {
            while (start <= mid ) {
                new_arr[idx] = arr[start];
                start++;
                idx++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = new_arr[i];
        }
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

                while (arr[high] >= pivot) {
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

    static void heap_sort(int[] arr, int size) {
        if (size < 2) {
            return ;
        }

        int parentIdx = getParent(size - 1);

        for (int i = parentIdx; i > 0; i--) {
            heapify(arr, i, size - 1);
        }

        for (int i = (size - 1); i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i-1);
        }
    }

    static int getParent(int childIdx) {
        return childIdx - 1 / 2;
    }

    static void heapify(int[] arr, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while ((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = parentIdx * 2 + 1;
            rightChildIdx = parentIdx * 2 + 2;
            largestIdx = parentIdx;

            if (arr[leftChildIdx] > arr[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && arr[rightChildIdx] > arr[largestIdx]) {
                largestIdx = rightChildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(arr, largestIdx, parentIdx);
                parentIdx = largestIdx;
            } else {
                return ;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
