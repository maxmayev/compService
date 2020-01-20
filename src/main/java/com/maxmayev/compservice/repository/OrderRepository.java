package com.maxmayev.compservice.repository;

import com.maxmayev.compservice.domain.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
   //List<Order> findByIdConsumer(int id);
    //Iterable<Order> findAll(Pageable pageRequest);
}
