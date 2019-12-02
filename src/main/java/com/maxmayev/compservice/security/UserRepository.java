package com.maxmayev.compservice.security;

import com.maxmayev.compservice.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

