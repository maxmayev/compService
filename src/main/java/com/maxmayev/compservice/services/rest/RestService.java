package com.maxmayev.compservice.services.rest;

import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import org.springframework.http.ResponseEntity;

public interface RestService {
    Iterable<Order> recentOrders(int size);
    Iterable<Order> findAll();
    ResponseEntity<Order> orderById(int id);
    Order newOrder(Order order);
    Consumer saveOrUpdateConsumer(Consumer consumer, Integer id);
    void deleteOrder(Integer id);
    void deleteConsumer(Integer id);
}
