package com.jiaying.controller;

import com.jiaying.entity.User;
import com.jiaying.entity.UserVO;
import com.jiaying.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/hello")
    public String hello(){
        return "helloworld";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page - 1) * limit;
        return new UserVO(0, "", userFeign.count(),userFeign.findAll(index, limit));
    }


    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/menu/redirect/user_manage";
    }

//    @PutMapping("/update")
//    public void update(@RequestBody User user){
//        userFeign.update(user);
//    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage";
    }
}
