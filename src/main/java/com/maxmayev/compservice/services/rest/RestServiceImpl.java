package com.maxmayev.compservice.services.rest;

import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RestServiceImpl implements RestService {

    OrderRepository orderRepository;

    @Autowired
    public RestServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> recentOrders(int size) {
        PageRequest page = PageRequest.of(0,size, Sort.by("id"));
        return orderRepository.findAll(page).getContent();
    }

    @Override
    public ResponseEntity<Order> orderById(int id) {
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()) return  new ResponseEntity<>(optional.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
