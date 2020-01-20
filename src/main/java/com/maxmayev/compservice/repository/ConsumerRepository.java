package com.maxmayev.compservice.repository;

import com.maxmayev.compservice.domain.Consumer;
import org.springframework.data.repository.CrudRepository;

public interface ConsumerRepository extends CrudRepository<Consumer,Integer> {
    //Consumer findById(int id);
    //Consumer save(Consumer consumer);
    //Consumer saveConsumerOrders(Consumer consumer, List<Order> orders);
    Consumer deleteById(int id);
   /* Consumer deleteById(int id);
    Consumer saveConsumerOrders(Consumer consumer, List<Order> orders);*/

}
