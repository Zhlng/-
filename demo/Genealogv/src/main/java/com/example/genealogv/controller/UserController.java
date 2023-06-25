package com.example.genealogv.controller;

import com.example.genealogv.entity.User;
import com.example.genealogv.mapper.UserMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired//注入userMapper
    private UserMapper userMapper;
    @GetMapping("/user")
    public List query(User user){
       List<User> list=userMapper.find();
        System.out.println(list);


        return list;

    }
   /* @GetMapping("/user/{User_id}")
    public String gstById(@PathVariable int User_id){
        userMapper.findByID();
        System.out.println(User_id);
        return "根据ID查询";
    }*/
    @PostMapping("/user")
    public List saveUser(User user){
        int i = userMapper.insert(user);
        if(i>0){
            return Collections.singletonList("插入成功");
        }
        else {
            return Collections.singletonList("插入失败");
        }

    }
    @PutMapping("/user")
    public List update(User user){
        userMapper.update(user);
        return Collections.singletonList("修改成功");
    }
    @DeleteMapping("/user")
    public List deleteUser(User user){
        userMapper.delete(user.getId());
        return Collections.singletonList("删除成功");
    }


}
