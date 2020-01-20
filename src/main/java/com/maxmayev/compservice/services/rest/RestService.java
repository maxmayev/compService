package com.maxmayev.compservice.services.rest;

import com.maxmayev.compservice.domain.Order;
import org.springframework.http.ResponseEntity;

public interface RestService {
    Iterable<Order> recentOrders(int size);
    ResponseEntity<Order> orderById(int id);
}
