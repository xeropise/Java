package base.threadpool;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Scheduler_ThreadPool {

    public static void main(String[] args) {

        // 지정된 delay 후에 실행하거나 주기적으로 실행하도록 명령을 예약가능
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        Runnable runnable = () -> System.out.println("Runnable task : " + LocalTime.now());
        int delay = 3;

        // Job을 스케쥴링합니다.
        System.out.println("Scheduled task : " + LocalTime.now() );
        ScheduledFuture future = scheduledExecutorService.schedule(runnable, delay, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

    }
}
