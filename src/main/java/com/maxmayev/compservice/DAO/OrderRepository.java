package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
   //List<Order> findByIdConsumer(int id);
    //Iterable<Order> findAll(Pageable pageRequest);
}
