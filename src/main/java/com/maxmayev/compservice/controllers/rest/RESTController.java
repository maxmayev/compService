package com.maxmayev.compservice.controllers.rest;
import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.services.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/tryrest", produces = "application/json")
@CrossOrigin(origins = "*")

public class RESTController {
    private RestService restService;


    @Autowired
    public RESTController(RestService restService) {
        this.restService = restService;
    }

    @GetMapping()
    public Iterable<Order> recentOrders(@RequestParam int size){
        return  restService.recentOrders(size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> orderById(@PathVariable int id){
        return restService.orderById(id);
    }
}
