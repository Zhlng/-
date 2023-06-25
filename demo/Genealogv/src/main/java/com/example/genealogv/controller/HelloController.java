package com.example.genealogv.controller;

import com.example.genealogv.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
public class HelloController {
    //http://localhost:8080/index
    //@RequestMapping(value = "/index")//这里默认的请求方式为get请求,get请求是web上的请求，修改请求方式用method
    @RequestMapping(value = "/index",method= RequestMethod.POST)

  public String index(User user){
        System.out.println(user);//单独在控制台打印出来
        return"";

    }
    //http://localhost:8080/index2?name=wdl&age=18
    /*@RequestMapping(value = "index2",method=RequestMethod.GET)
    public String index2(String name,String age){

        return "我是"+name+" "+"今年"+age;

    }

    @GetMapping(value = "/text/**")
    public String test(){
        return"通配符请求";
    }

}*/