package com.design_patterns.observer.Shop;

import com.design_patterns.observer.dto.Message;
import com.design_patterns.observer.publisher.EventManager;

// Singleton class
public class Shop {
    public EventManager events;
    private Message message;
    private static Shop shop = null;

    private Shop(){
        this.events = new EventManager("Iphone stock refilled", "Iphone out of stock");
    }

    public static synchronized Shop getInstance(){

        if (shop == null){
            shop = new Shop();
        }
        return shop;
    }

    public void stockRefill(){
        this.message = new Message(200, "Iphone restocked, visit the store now and get yours!");
        events.notifySubscribers("Iphone stock refilled", this.message);
    }

    public void stockOut(){
        this.message = new Message(123, "Unfortunately, IPhone went out of stock");
        events.notifySubscribers("Iphone out of stock", this.message);
    }
}
