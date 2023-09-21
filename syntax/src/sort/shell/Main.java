package sort.shell;

import java.util.Arrays;

public class Main {
    private static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

    public static void main(String[] args) {

        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int [] arr) {
        // 삽입 정렬을 나눠서 정렬
        for (int h = arr.length/2; h > 0; h /= 2) {

            // 이하는 삽입 정렬임
            for (int i = h; i < arr.length; i++) {
                int prev = (i - h);
                int target = arr[i];

                while ((prev >= 0) && (arr[prev] > target) ) {
                    // 삽입 정렬 처럼 위치를 바꿔 준다.
                    arr[prev + h] = arr[prev];
                    prev -= h;
                }

                // 위 while 에서 탈출했을 때 prev는 이전 값 위치에 도달할 수 있도록 h를 더해 준다.
                arr[prev + h] = target;
            }
        }
    }
}
