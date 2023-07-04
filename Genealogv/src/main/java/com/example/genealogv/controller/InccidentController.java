package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Inccident;
import com.example.genealogv.mapper.InccidentMapper;
import com.example.genealogv.service.InccidentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@Api("事件管理")
@RequestMapping("/inccident")
public class InccidentController{
    @Autowired
    private InccidentService inccidentService;

    @Autowired
    private InccidentMapper inccidentMapper;

    @ApiOperation("查看所有事件")
    @GetMapping("/list")
    public List<Inccident>list(){

        return inccidentService.list();

    }
    @ApiOperation("插入新事件")
    @PostMapping ("/save")
    public boolean save(@RequestBody Inccident inccident){

        return inccidentService.save(inccident);

    }
    @ApiOperation("删除事件")
    @RequestMapping("/delete")
    public boolean delete(@RequestBody Inccident inccident){

        return inccidentMapper.delete(inccident);
    }
    @ApiOperation("修改事件")
    @PostMapping("/change")
    public boolean change(@RequestBody Inccident inccident){

        return inccidentService.updateById(inccident);

    }
    @ApiOperation("查看某一个事件")
    @PostMapping("/select")
    public List<Inccident> selecte(@RequestBody Inccident inccident){
        LambdaQueryWrapper<Inccident>lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Inccident::getInccidentType,inccident.getInccidentType());
        return inccidentService.list(lambdaQueryWrapper);
    }
}
