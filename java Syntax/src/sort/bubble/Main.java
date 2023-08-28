package sort.bubble;

public class Main {
    public static void main(String[] args) {

        /***
            숫자의 순서가 [ 6, 4, 3, 7, 1, 9, 8 ] 일 경우
            오름차순으로 정렬한다고 하면?
            6과 4를 비교했을 때 왼쪽 값이 오른쪽 값보다 작아야 한다. ( a < b )

            시간 복잡도가 O(n²) 으로 상당히 느리다.
         */

        int[] arr = { 6, 4, 3, 7, 1, 9, 8};

        int[] sortedArr = bubbleSort(arr.clone());

        for (int i = 0; i < sortedArr.length; i++) {
            System.out.println(sortedArr[i]);
        }
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = (i+1); j < arr.length; j++) {
                int temp = 0;
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }
}
