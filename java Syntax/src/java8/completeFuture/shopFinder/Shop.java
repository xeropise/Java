package java8.completeFuture.shopFinder;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Shop {

    private String shopName;

    public final static Random random = new Random();

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public String getName() {
        return this.shopName;
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    /* Thread를 생성하여 실행
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price); // 계산이 정상적으료 종료되면 Future에 가격 정보를 저장한 채로 Future를 종료
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex); // 도중에 문제가 발생하면 발생한 에러를 포함시켜 Future를 종료
            }
        }).start();
        return futurePrice;
    }
     */

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
             Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
