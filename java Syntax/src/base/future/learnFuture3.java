package base.future;

import java.time.LocalTime;
import java.util.concurrent.*;

public class learnFuture3 {

    public static void main(String[] args) {

        // future에 data가 set 되지 않으면 무한 대기하므로 Timeout 을 설정할 수 있다.
        ExecutorService executor
                = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            System.out.println(LocalTime.now() + " Starting runnable");
            Integer sum = 1 + 1;
            Thread.sleep(4000);
            System.out.println(LocalTime.now() + " Exiting runnable");
            return sum;
        });

        System.out.println(LocalTime.now() + " Waiting the task done");
        Integer result = null;
        try {
            result = future.get(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.out.println(LocalTime.now() + " Timed out");
            result = 0;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalTime.now() + " Result : " + result);

        executor.shutdown();
    }
}
