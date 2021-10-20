package base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Single_ThreadPool {

    public static void main(String[] args) {
        // 단일 Worker Thread
        // 실패 시, 새로운 Thread를 생성하지 않는다. (한번 중단하면 다시 사용할 수 없다)
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute( () -> System.out.println("싱글 쓰레드 풀 익스큐터"));

        //shutdown 시키지 않으면 비정상 종료 될 수 있다고 한다.
        executorService.shutdown();

    }
}
