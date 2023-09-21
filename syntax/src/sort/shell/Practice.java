package sort.shell;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1};

        shell_sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void shell_sort(int[] arr) {
        // 간격을 반절씩 좁힌다.
        for (int h = arr.length/2; h > 0; h /= 2) {

            // 여기서 헷갈릴 수 있는데 부분리스트를 하나씩 비교하는 것이다.
            // 삽입 정렬을 시행
            for (int i = h; i < arr.length; i++) {
                int prev = (i - h);
                int target = arr[i];

                // 여기도 헷갈리기 쉽다. 간격 만큼 옮겨 줘야 한다.
                while(prev >= 0 && arr[prev] > target) {
                    arr[prev + h] = arr[prev];
                    prev -= h;
                }
                // 루프에서 빠져나온 경우,
                // prev 값은 삽입되어야 할 위치보다 한 간격 앞에 있으므로
                arr[prev + h] = target;
            }
        }
    }
}
