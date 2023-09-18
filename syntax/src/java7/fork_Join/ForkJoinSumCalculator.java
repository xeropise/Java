package java7.fork_Join;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers; // 더할 숫자 배열
    private final int start; // 서브태스크에서 처리할 배열의 초기 위치
    private final int end; // 서브태스크에서 처리할 배열의 최종 위치
    public static final long THRESHOLD = 10_000; // 이 값이하로는 분할 불가

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return compueSequentially();
        }

        // TODO(ForkJoin 완료 해야함)
        /*
        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator();

         */

        return 0L;
    }

    private long compueSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
