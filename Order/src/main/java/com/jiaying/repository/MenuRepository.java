package com.jiaying.repository;

import com.jiaying.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository {
    public Menu findById(long id);
}
