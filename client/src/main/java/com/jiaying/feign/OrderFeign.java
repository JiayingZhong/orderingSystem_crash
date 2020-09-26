package com.jiaying.feign;

import com.jiaying.entity.Order;
import com.jiaying.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderFeign {
    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index,
                                @PathVariable("limit") int limit,
                                @PathVariable("uid") long uid);


    @GetMapping("/order/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index") int index,
                           @PathVariable("limit") int limit);


    @GetMapping("/order/updateState/{id}")
    public OrderVO updateState(@PathVariable("id") long id);

}
