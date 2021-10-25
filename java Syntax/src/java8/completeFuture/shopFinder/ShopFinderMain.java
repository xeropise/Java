package java8.completeFuture.shopFinder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public class ShopFinderMain {

    public static void main(String[] args) {

        Shop shop = new Shop("BestShop");

        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");

        long invociationTime = ((System.nanoTime() - start) / 1_000_000);

        /*
           제품의 가격을 계산하는 동안
           다른 상점 검색 등 다른 작업 수행
         */
        //doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTIme = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTIme + " msecs");
    }


}
