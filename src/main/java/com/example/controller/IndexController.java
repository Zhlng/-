package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;

@Controller
public class IndexController {
    @RequestWrapper(localName = "index")
    @ResponseBody
    public String Index(){
        return "hello world";
    }
}
