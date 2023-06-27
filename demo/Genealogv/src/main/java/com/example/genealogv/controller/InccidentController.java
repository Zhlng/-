package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Inccident;
import com.example.genealogv.service.InccidentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Api("事件管理")
@RequestMapping("/inccident")
public class InccidentController{
    @Autowired(required = false)
    private InccidentService inccidentService;
    @GetMapping("/list")
    public List<Inccident>list(){

        return inccidentService.list();

    }
    @PostMapping ("/save")
    public boolean save(@RequestBody Inccident inccident){

        return inccidentService.save(inccident);

    }
    @GetMapping("/delete")
    public boolean delete(int PersonnelId){

        return inccidentService.removeById(PersonnelId);
    }
    @PostMapping("/change")
    public boolean change(@RequestBody Inccident inccident){

        return inccidentService.updateById(inccident);

    }
    @PostMapping("/selecte")
    public List<Inccident> selecte(@RequestBody Inccident inccident){

        LambdaQueryWrapper<Inccident>lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Inccident::getPersonnelId,inccident.getPersonnelId());
        return inccidentService.list(lambdaQueryWrapper);
    }
}
