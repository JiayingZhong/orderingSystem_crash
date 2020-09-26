package com.jiaying.repository;

import com.jiaying.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    public User findById(long id);
}
