package java8.stream;

import java.util.function.Function;
import java.util.stream.LongStream;

public class Stream_API_parallel2 {

    public static void main(String[] args) {

        System.out.println("Sequential range sum done in: " + measureSumPerf(Stream_API_parallel2::rangedSum, 10_000_000));

        System.out.println("Parallel range sum done in: " + measureSumPerf(Stream_API_parallel2::parallelRangedSum, 10_000_000));

        /*
            이번엔 병렬 연산이 제대로 동작하고 있다... 대체 왜?

            이전 예제의 iterate에 비해
            - LongStream.rangeClosed는 기본형 long을 직접 사용하므로 박싱과 언박싱 오버헤드가 적다.
            - LongStream.rangeClosed는 쉽게 청크로 분할할 수 있는 숫자 범위를 생산하다.

            상황에 따라서는 어떤 알고리즘을 병렬화하는 것보다 적절한 자료구조를 선택하는 것이 더 중요하다.

            하지만, 병렬화가 완전 공짜는 아님
            - 스트림을 재귀적으로 분할해야 하고, 각 서브 스트림을 서로 다른 스레드의 리듀싱 연산으로 할당하고, 이들 결과를 하나의 값으로 합쳐야 한다.
            - 멀티코어 간의 데이터 이동의 비용은 생각보다 비싸며, 코어 간에 데이터 전송 시간보다 훨씬 오래 걸리는 작업만 병렬로 다른 코어에서 수행하는 것이 바람직하다.
            - 상황에 따라 쉽게 병렬화를 이용할 수 있거나 아니면 아예 병렬화를 이용할 수 없는 때도 있는데 이를 잘 구분해야 한다.
            - 스트림을 병렬화해서 코드 실행 속도를 빠르게 하고 싶으면 항상 병렬화를 올바르게 사용하고 있는지 확인해야 한다.
         */
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                        .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                        .parallel()
                        .reduce(0L, Long::sum);
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
}
