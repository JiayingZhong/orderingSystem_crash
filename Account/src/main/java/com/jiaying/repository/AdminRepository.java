package com.jiaying.repository;

import com.jiaying.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {
    public Admin login(String username, String password);
}
