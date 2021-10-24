package java8.completeFuture.shopFinder;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private String shopName;

    public final static Random random = new Random();

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
            double price = calculatePrice(product); // 다른 쓰레드에서 비동기 수행
            futurePrice.complete(price); // 오랜 시간이 걸리는 계산이 완료되면 Future에 값을 설정
        }).start();
        return futurePrice;  // 계산 결과가 완료되길 기다리지 않고 Future를 반환
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
