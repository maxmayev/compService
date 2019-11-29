package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Order;

public interface OrderRepository {
    Iterable<Order> getOrdersByConsumerId(int id);
}
