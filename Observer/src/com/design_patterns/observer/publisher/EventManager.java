package com.design_patterns.observer.publisher;

import com.design_patterns.observer.dto.Message;
import com.design_patterns.observer.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations){
        // can use any number of args, keeping at as generic as i can
        for(String operation: operations){
            this.listeners.put(operation, new ArrayList<>()); // for each of the event type, initiate a new listener array.
        }
    }

    public void subscribe(String eventType, EventListener eventListener){
        List<EventListener> users = listeners.get(eventType);     // using the event type query for the existing subscriber list
        users.add(eventListener); // add the new subscriber
    }

    public void unsubscribe(String eventType, EventListener eventListener){
        List<EventListener> users = listeners.get(eventType);
        users.remove(eventListener);
    }

    public void notifySubscribers(String eventType, Message message){
        List<EventListener> users = listeners.get(eventType); // Query for all the subscribers of the particular event using the eventType
        for (EventListener listener : users){           // Loop over and notify all the subscribers about the event
            listener.update(eventType, message);
        }
    }
}
