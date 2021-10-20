package base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cached_ThreadPool {

    public static void main(String[] args) {

        // 필요에 따라서 새로운 Thread를 생성하며, 이전에 생성된 Thread가 존재하면 재사용.
        // 기본적으로 60초 정도 Thread가 유지.
        // 비동기 작업을 하는데 좋음
        // new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        // 기본 생성 숫자가 0으로 시작하고 필요할때 마다 갯수를 늘려가는 형태
        ExecutorService executorService = Executors.newCachedThreadPool();


    }
}
