import com.design_patterns.observer.Shop.Shop;
import com.design_patterns.observer.listener.User;

public class Main {
    public static void main(String[] args) {
        Shop shop = Shop.getInstance();

        // users creation
        User user1 =  new User("Sridhar");
        User user2 = new User("Hello");

        // subscriber users to shop events
        shop.events.subscribe("Iphone stock refilled", user1);
        shop.events.subscribe("Iphone out of stock", user1);
        shop.events.subscribe("Iphone stock refilled", user2);

        // Trigger events
        shop.stockRefill();
        shop.stockOut();
    }
}