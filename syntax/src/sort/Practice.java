package sort;

import java.util.Arrays;

public class Practice {

    static int[] new_arr;

    static int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static void main(String[] args) {

        new_arr = new int[arr.length];

        heap_sort(arr);

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
        for (int i = 0; i < arr.length -1; i++) {
            int minIdx = i;
            for (int j = (i+1); j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    static void insertion_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = (i-1);

            while (j >= 0 && arr[j] > target) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = target;
        }
    }

    static void shell_sort(int[] arr) {
        for (int h = arr.length/2; h > 0; h /=2 ) {
            for (int i = h; i < arr.length; i++) {
                int target = arr[i];
                int j = (i - h);

                while (j >= 0 && arr[j] > target) {
                    arr[j+h] = arr[j];
                    j -= h;
                }

                arr[j+h] = target;
            }
        }
    }

    static void heap_sort(int[] arr) {
        heap_sort(arr, arr.length);
    }

    static void heap_sort(int[] arr, int size) {
        if (size < 2) {
            return ;
        }

        int parentIdx = getParent(size - 1);

        for (int i = parentIdx; i >= 0; i--) {
            heapify(arr, i, size - 1);
        }


        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i-1);
        }

    }

    private static int getParent(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private static void heapify(int[] arr, int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightchildIdx;
        int largestIdx;

        while ((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = parentIdx * 2 + 1;
            rightchildIdx = parentIdx * 2 + 2;
            largestIdx = parentIdx;

            if (arr[leftChildIdx] > arr[largestIdx]) {
                largestIdx = leftChildIdx;
            }

            if (rightchildIdx <= lastIdx && arr[rightchildIdx] > arr[largestIdx]) {
                largestIdx = rightchildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(arr, largestIdx, parentIdx);
                parentIdx = largestIdx;
            } else {
                return ;
            }
        }
    }

    static void merge_sort(int[] arr) {
        merge_sort(arr, 0, arr.length - 1);
    }

    static void merge_sort(int[] arr, int left, int right) {
        if (left == right) {
            return ;
        }

        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);

        merge_sort(arr, mid + 1, right);

        merge_sort(arr, left, mid, right);
    }

    static void merge_sort(int[] arr, int left, int mid, int right) {
        int start = left;
        int nextStart = (mid + 1);
        int idx = left;

        while (start <= mid && nextStart <= right) {
            if (arr[start] <= arr[nextStart]) {
                new_arr[idx] = arr[start];
                idx++;
                start++;
            } else {
                new_arr[idx] = arr[nextStart];
                idx++;
                nextStart++;
            }
        }

        if (start > mid) {
            while (nextStart <= right) {
                new_arr[idx] = arr[nextStart];
                idx++;
                nextStart++;
            }
        } else {
            while (start <= mid) {
                new_arr[idx] = arr[start];
                idx++;
                start++;
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = new_arr[i];
        }
    }

    static void quick_sort(int[] arr) {
        quick_sort(arr, 0, arr.length - 1);
    }

    static void quick_sort(int[] arr, int left, int right) {
        int start = left;
        int end = right;
        int mid = (start + end) / 2;
        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] <= pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        if (start < right) {
            quick_sort(arr, start, right);
        }

        if (left < end) {
            quick_sort(arr, left, end);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
