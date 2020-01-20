package com.maxmayev.compservice.services.consumer;

import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.SessionStatus;

public interface ConsumerService {
    Boolean addConsumer(Consumer consumer, Errors errors);
    void addOrderToConsumer(Consumer consumer, Order order);
    void saveConsumer(Consumer consumer, SessionStatus sessionStatus);
    void deleteConsumer(String id);
}
