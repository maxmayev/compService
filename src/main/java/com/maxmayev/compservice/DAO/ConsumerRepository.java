package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.Order;

import java.util.List;

public interface ConsumerRepository {
    Iterable<Consumer> findAll();
    Consumer findOne(int id);
    Consumer save(Consumer consumer);
    Consumer saveConsumerOrders(Consumer consumer, List<Order> orders);
    Consumer deleteById(String id);

}
