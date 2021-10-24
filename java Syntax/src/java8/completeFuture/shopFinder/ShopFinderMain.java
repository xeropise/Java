package java8.completeFuture.shopFinder;

import java.util.concurrent.Future;

public class ShopFinderMain {

    public static void main(String[] args) {

        Shop shop = new Shop("BestShop");

        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");

    }
}
