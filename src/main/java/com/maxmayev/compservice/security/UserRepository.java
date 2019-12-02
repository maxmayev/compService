package com.maxmayev.compservice.DAO;

import com.maxmayev.compservice.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

