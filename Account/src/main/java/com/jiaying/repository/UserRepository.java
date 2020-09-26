package com.jiaying.repository;

import com.jiaying.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public User login(String username, String password);
}
