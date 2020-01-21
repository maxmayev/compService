package com.maxmayev.compservice.controllers.rest;
import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.services.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public Iterable<Order> recentOrders(@RequestParam int size){
        return  restService.recentOrders(size);
    }

    @GetMapping("/orders/all")
    public Iterable<Order> findAll(){
        return restService.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> orderById(@PathVariable int id){
        return restService.orderById(id);
    }

    @PostMapping("/orders/new")
    public Order newOrder(@RequestBody Order order){
        return restService.newOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Consumer saveOrUpdateConsumer(@RequestBody Consumer consumer, @PathVariable Integer id){
        return restService.saveOrUpdateConsumer(consumer,id);
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
