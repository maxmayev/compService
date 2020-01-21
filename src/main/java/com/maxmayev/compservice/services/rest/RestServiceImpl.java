package com.maxmayev.compservice.services.rest;

import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.repository.ConsumerRepository;
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
    ConsumerRepository consumerRepository;

    @Autowired
    public RestServiceImpl(OrderRepository orderRepository, ConsumerRepository consumerRepository) {
        this.orderRepository = orderRepository;
        this.consumerRepository = consumerRepository;
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

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order newOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Consumer saveOrUpdateConsumer(Consumer consumer, Integer id) {
        return consumerRepository.findById(id).map(x -> {
            x.setName(consumer.getName());
            x.setSurname(consumer.getSurname());
            x.setPatronymic(consumer.getPatronymic());
            x.setPhoneNumber(consumer.getPhoneNumber());
            return consumerRepository.save(x);
        }).orElseGet(() -> {
            consumer.setId(id);
            return consumerRepository.save(consumer);
        });
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteConsumer(Integer id) {
        consumerRepository.deleteById(id);
    }
}
