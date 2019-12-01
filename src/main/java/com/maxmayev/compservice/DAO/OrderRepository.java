package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Integer> {
   //List<Order> findByIdConsumer(int id);
}
