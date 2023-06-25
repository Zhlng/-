package com.example.genealogv.controller;
//用户
import com.example.genealogv.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @ApiOperation("获取用户")
    @GetMapping("/user/{id}")
    public String getUserByld(@PathVariable int id){

        System.out.println(id);
        return"根据ID获取用户信息";

    }

    @ApiOperation("添加用户")
    @PostMapping("/user")
    public String save(User user){

        return"添加用户";

    }

    @ApiOperation("修改用户")
    @PutMapping("/user")
    public String update(User user){

        return "更新用户";

    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public String deleteByld(@PathVariable int id){

        System.out.println(id);
        return "根据ID删除用户";
    }


}
