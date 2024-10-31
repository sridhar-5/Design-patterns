package com.design_patterns.observer.listener;

import com.design_patterns.observer.dto.Message;

public class User implements EventListener {

    public String name;

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String eventType, Message message) {
        System.out.println("User " + name + " received notification:");
        System.out.println("Event Type: " + eventType);
        System.out.println("Message #id "+ message.getId() + " : " + message.getText());
    }
}
