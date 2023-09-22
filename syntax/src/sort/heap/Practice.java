package sort.heap;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] a) {
        sort(a, a.length);
    }

    private static void sort(int[] arr, int size) {

        if (size < 2) {
            return;
        }

        int parentIdx = getParent(size - 1);

        for (int i = parentIdx; i >= 0; i--) {
            heapify(arr, parentIdx, size - 1);
        }

        for (int i = size-1; i > 0; i--) {

            swap(arr, 0, i);
            heapify(arr, 0 ,i-1);
        }
    }

    private static int getParent(int child) {
        return (child - 1) / 2;
    }

    private static void heapify(int[] arr, int parentIdx,  int lastIdx) {
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

            if (arr[rightChildIdx] > arr[largestIdx] && rightChildIdx <= lastIdx) {
                largestIdx = rightChildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(arr, largestIdx, parentIdx);
                parentIdx = largestIdx;
            } else {
                return;
            }
        }
    }

    // 두 인덱스의 원소를 교환하는 함수
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}