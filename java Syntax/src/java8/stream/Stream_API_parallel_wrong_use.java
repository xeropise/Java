package java8.stream;

import java.util.function.Function;
import java.util.stream.LongStream;

public class Stream_API_parallel_wrong_use {

    public static void main(String[] args) {
        /*
            예상된 결과 50000005000000 가 나오지 않는다.
         */
        System.out.println("SideEffect parallel sum done in: " +  measureSumPerf(Stream_API_parallel_wrong_use::sideEffectParallelSum, 10_000_000L)
                + " msecs" );
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;

        for (int i =0; i< 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result : " + sum);
            if (duration < fastest) fastest = duration;
        }

        return fastest;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        public long total = 0;

        // total에 접근할 때마다 다수의 스레드에서 동시에 접근하기 때문에 데이터 레이스 문제가 반드시 일어난다.
        // 동기화로 문제를 해결하다보면 결국 병렬화라는 특성이 필요가 없다.
        public void add(long value) { total += value; }
    }
}
