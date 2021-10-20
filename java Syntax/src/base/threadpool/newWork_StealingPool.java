package base.threadpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class newWork_StealingPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 자바 8 부터 지원
        // 내부적으로 ForkJoinPool을 사용하고 있다.
        // 고정된 크기의 풀 사이즈를 사용하는게 아니라 호스트 컴퓨터의 CPU의 가용한 코어의 갯수에 대응하는 크기로 풀 사이즈를 챙겨간다.
        // https://smlee729.wordpress.com/2016/07/02/newworkstealingpool/ 참조
        // new ForkJoinPool
        //            (Runtime.getRuntime().availableProcessors(),
        //             ForkJoinPool.defaultForkJoinWorkerThreadFactory,
        //             null, true);
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "a",
                () -> "b",
                () -> "c"
        );

        List<Future<String>> result = executorService.invokeAll(callables);

        for(Future<String> each : result) {
            System.out.println(each.get());
        }

        executorService.shutdown();
    }
}
