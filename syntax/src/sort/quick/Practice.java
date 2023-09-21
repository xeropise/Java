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

        int mid = (left + right) / 2;

        int pivot = arr[mid];

        while(low <= high) {

            // 왼쪽 그룹에서 pivot 보다 같거나 높은 값을 탐색한다.
            while(arr[low] < pivot) {
                low++;
            }

            // 오른쪽 그룹에서 pivot 보다 같거나 낮은 값을 탐색한다.
            while(arr[high] > pivot) {
                high--;
            }

            // 탐색을 완료했으면 교환한다.
            // 교환 후에 탐색을 또 진행해야 하므로 값을 변경 시킨다.
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        // 탐색이 종료되었다면, low와 high 교차되었다. (low > high)

        // 오른쪽 탐색을 한다.
        if (low < right) {
            quick_sort(arr, low, right);
        }

        // 왼쪽 탐색을 한다.
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
