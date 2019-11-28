package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.Consumer;

public interface ConsumerRepository {
    Iterable<Consumer> findAll();
    Consumer findOne(int id);
    Consumer save(Consumer consumer);
    Consumer deleteById(String id);

}
