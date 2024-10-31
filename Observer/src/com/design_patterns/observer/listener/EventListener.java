package com.design_patterns.observer.listener;

import com.design_patterns.observer.dto.Message;

public interface EventListener {
    void update(String eventType, Message message);
}
