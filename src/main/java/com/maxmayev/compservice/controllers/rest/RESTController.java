package com.maxmayev.compservice.controllers.rest;
import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.services.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/rest", produces = "application/json")
@CrossOrigin(origins = "*")

public class RESTController {
    private RestService restService;


    @Autowired
    public RESTController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("/orders/recent")
    public ResponseEntity<List<Order>> recentOrders(@RequestParam int size){
        List<Order> orders = new ArrayList<>();
        restService.recentOrders(size).forEach(orders::add);
        return  !orders.isEmpty() ? new ResponseEntity<>(orders, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orders/all")
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders = new ArrayList<>();
        restService.findAll().forEach(orders::add);
        return !orders.isEmpty() ? new ResponseEntity<>(orders, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> orderById(@PathVariable int id){
        return restService.orderById(id);
    }

    @PostMapping("/orders/new")
    public ResponseEntity<?> newOrder(@RequestBody Order order){
        return restService.newOrder(order)!= null ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/consumer/{id}")
    public ResponseEntity<?> saveOrUpdateConsumer(@RequestBody Consumer consumer, @PathVariable Integer id){
        return restService.saveOrUpdateConsumer(consumer,id)!= null ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id){
        restService.deleteOrder(id);
    }

    @DeleteMapping("/consumers/{id}")
    public void deleteConsumer(@PathVariable Integer id){
        restService.deleteConsumer(id);
    }



}
