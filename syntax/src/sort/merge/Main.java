import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        sorted = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sorted[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(Arrays.copyOf(sorted, sorted.length), 0, sorted.length - 1);

        br.close();
    }

    static void merge_sort(int[] arr, int left, int right) {

        if(left == right) {
            return;
        }

        int mid = (left + right) / 2;

        merge_sort(arr, left, mid); // 절반 중 왼쪽 부분리스트 (left ~ mid)
        merge_sort(arr, mid + 1, right); // 절반 중 오른쪽 부분리스트 (mid+1 ~ right)
        merge(arr, left, mid, right); // 병합 작업
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int start = left;
        int end = (mid + 1);
        int idx = left;

        while(start <= mid && end <= right) {
            /*
             *  왼쪽 부분리스트 start번째 원소가 오른쪽 부분리스트 end번째 원소보다 작거나 같을 경우
             *  왼쪽의 start번째 원소를 새 배열에 넣고 start과 idx를 1 증가시킨다.
             */
            if (arr[start] <= arr[end]) {
                sorted[idx] = arr[start];
                idx++;
                start++;

                /*
                 *  오른쪽 부분리스트 end번째 원소가 왼쪽 부분리스트 start번째 원소보다 작거나 같을 경우
                 *  오른쪽의 end번째 원소를 새 배열에 넣고 end과 idx를 1 증가시킨다.
                 */
            } else {
                sorted[idx] = arr[end];
                idx++;
                end++;
            }
        }

        /*
         * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (start > mid)
         * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
         * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
         */
        if (start > mid) {
            while(end <= right) {
                sorted[idx] = arr[end];
                idx++;
                end++;
            }

            /*
             * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (end > right)
             * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
             * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
             */
        } else {
            while(start <= mid) {
                sorted[idx] = arr[start];
                idx++;
                start++;
            }
        }

        /*
         * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
         */
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}