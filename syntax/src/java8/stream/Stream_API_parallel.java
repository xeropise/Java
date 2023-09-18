package java8.stream;

import java.util.function.Function;
import java.util.stream.Stream;

public class Stream_API_parallel {

    public static void main(String[] args) {

        // stream Sum Test
        System.out.println("Sequential sum done in: " + measureSumPerf(Stream_API_parallel::sequentialSum, 10_000_000) + " msecs");

        // forLoop Sum Test
        System.out.println("Iterative sum done in: " + measureSumPerf(Stream_API_parallel::iterativeSum, 10_000_000) + " msecs");

        // parellel Sum Test
        System.out.println("Parallel sum done in: " + measureSumPerf(Stream_API_parallel::parallelSum, 10_000_000) + " msecs");

        // 결과는 parellel 로 실행하는데 더느리다.. ?? 어떻게 돌아가는지 이해가 필요

        // Stream의 iterate 객체에 문제가 있다.
        // iterate가 박싱된 객체를 생성하는데, 이를 다시 언박싱하는 과정이 필요
        // iterate는 병렬로 실행될 수 있도록 독립적인 청크로 분할하기가 어렵다.

        // 병렬과 거리가 먼 객체를 사용하는 경우 전체 프로그램의 성능이 더 나빠질 수 있다.
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /*
        병렬 스트림음 내부적으로 ForkJoinPool 을 사용, Runtime.getRuntime().availableProcessors()로 JVM 이 이용가능한 코어개수에 상응하는 쓰레드를 갖는다.

     */

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .parallel()
                     .reduce(0L, Long::sum);
    }

    // n개의 숫자를 더하는 함수의 성능 측정
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


}
