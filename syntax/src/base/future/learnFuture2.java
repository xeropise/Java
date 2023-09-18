package base.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class learnFuture2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            System.out.println(Thread.currentThread().getName() + " Doing somehing");
            Integer sum = 1 + 1;
            Thread.sleep(3000);
            future.complete(sum);
            return null;
        });

        System.out.println(Thread.currentThread().getName() + " Waiting Task Done");
        Integer result = future.get();

        System.out.println("Result : " + result);
    }

}
