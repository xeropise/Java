package base.threadpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Fixed_ThreadPool {

    public static void main(String[] args) {
        // 고정된 Worker Thread를 사용하며, 모든 Thread가 사용중이라면 Queue에 쌓아 대기
        // 실패 시, 새로운 Thread를 생성하여 대체함
        // 자세한 사용법은 https://hamait.tistory.com/937 참조

        ExecutorService executor = Executors.newFixedThreadPool(2);

        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Future<Integer> future = executor.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(5000);
            int result = integers.stream().mapToInt(i -> i.intValue()).sum();
            return result;
        });

        try {
            Integer result = future.get();
            System.out.print("result: " + result);
            if (future.isDone()) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();

        }


    }
}
