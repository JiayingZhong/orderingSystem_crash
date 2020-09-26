package com.jiaying.controller;

import com.jiaying.entity.Order;
import com.jiaying.entity.OrderVO;
import com.jiaying.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "heloworld!";
    }


    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index,
                                @PathVariable("limit") int limit,
                                @PathVariable("uid") long uid){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(index, limit, uid));
        return orderVO;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.count());
        orderVO.setData(orderRepository.findAll(index, limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") long id){
        orderRepository.updateState(id);
    }
}
