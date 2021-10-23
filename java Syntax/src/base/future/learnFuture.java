package base.future;

import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class learnFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // future.get()이 결과를 가져올때 까지 진행하던 메인쓰레드가 블로킹 되는 단점이 있다. 생성자에 타임아웃 시간을 줄 수 있음
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> {
            System.out.println(LocalTime.now() + " Starting Runnable");
            System.out.println(Thread.currentThread().getName() + " 시작");
            Integer sum = 1 + 1;
            Thread.sleep(3000);
            return sum ;
        });

        System.out.println(LocalTime.now());
        System.out.println(Thread.currentThread().getName() + " 시작");
        Integer result = future.get();
        System.out.println(LocalTime.now() + " Result : " + result);
    }
}
