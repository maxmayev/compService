package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsumerRepository extends CrudRepository<Consumer,Integer> {
    //Consumer findById(int id);
    //Consumer save(Consumer consumer);
    //Consumer saveConsumerOrders(Consumer consumer, List<Order> orders);
    Consumer deleteById(int id);
   /* Consumer deleteById(int id);
    Consumer saveConsumerOrders(Consumer consumer, List<Order> orders);*/

}
