package com.jiaying.controller;

import com.jiaying.entity.Menu;
import com.jiaying.entity.MenuVO;
import com.jiaying.entity.Type;
import com.jiaying.repository.MenuRepository;
import com.jiaying.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<Menu> list = menuRepository.findAll(index, limit);
        return new MenuVO(0, "", menuRepository.count(), list);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }


}
