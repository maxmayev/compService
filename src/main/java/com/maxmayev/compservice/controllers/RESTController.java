package com.maxmayev.compservice.controllers;

import com.maxmayev.compservice.DAO.OrderRepository;
import com.maxmayev.compservice.Order;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/tryrest", produces = "application/json")
@CrossOrigin(origins = "*")

public class RESTController {
    private OrderRepository orderRepository;

    @Autowired
    EntityLinks entityLinks;


    public RESTController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public Iterable<Order> recentOrders(){
        PageRequest page = PageRequest.of(0,5, Sort.by("id"));
        return orderRepository.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public Order byIdOrder(@PathVariable int id){
        Optional<Order> optional = orderRepository.findById(id);
        return optional.orElse(null);
    }
}
