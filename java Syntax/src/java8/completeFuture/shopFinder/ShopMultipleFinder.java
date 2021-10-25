package java8.completeFuture.shopFinder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShopMultipleFinder {

    private static List<Shop> shops;

    public static void main(String[] args) {

        shops = Arrays.asList(
                new Shop("Best Practice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll")
        );

    }

    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    //위의 findPrices 성능 개선
    // https://www.popit.kr/java8-stream%EC%9D%98-parallel-%EC%B2%98%EB%A6%AC/ 참조 para
    public List<String> findPricesParellel(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is $.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }
}
