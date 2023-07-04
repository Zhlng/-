package com.example.genealogv.controller;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.User;
import com.example.genealogv.mapper.UserMapper;
import com.example.genealogv.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController{

@Autowired
    private UserService userService;

@Autowired
private UserMapper userMapper;


/*@ApiOperation("查看用户和家族")//一对多
@GetMapping("/findAll")
public List<User>find(){return userMapper.selectAllUserAndFamilies();}*/
@ApiOperation("查看全部用户")
@GetMapping("/list")//查看所有
public List<User> list(){
    return userService.list();
}
@ApiOperation("插入用户")
@PostMapping("/save")//增
    public boolean save(@RequestBody User user){
    return userService.save(user);
}
@ApiOperation("删除用户")
@GetMapping("/delete")//删
    public boolean delete(int UserId){
    return userService.removeById(UserId);
}
@ApiOperation("修改用户")
@PostMapping("/change")//改
    public boolean change(@RequestBody User user){

    return userService.updateById(user);}
@ApiOperation("查看用户")
@PostMapping("/select")//根据ID查看某个
    public List<User> select(@RequestBody User user){
    LambdaQueryWrapper<User>lambdaQueryWrapper=new LambdaQueryWrapper();
    lambdaQueryWrapper.eq(User::getUserId,user.getUserId());
    return userService.list(lambdaQueryWrapper);
}

    @ApiOperation("登录接口")
    @RequestMapping("/login")
    public Map login(@RequestBody User users){
        Map map = new HashMap<>();
        User list = userMapper.getByNameAndPwd(users);
        if(list != null){
            map.put("code",200);
            map.put("msg","登录成功");
            map.put("data",list);
        }else{
            map.put("code",-1);
            map.put("msg","账号密码错误!");
        }
        return map;
    }

}
