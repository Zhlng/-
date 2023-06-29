package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.service.PersonnelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("人员管理")
@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    private PersonnelService personnelService;
    @ApiOperation("查看所有人员")
    @GetMapping("/list")
    public List<Personnel>list(){

        return personnelService.list();

    }
    @ApiOperation("插入新人员")
    @PostMapping("/save")
    public boolean save(@RequestBody Personnel personnel){

        return personnelService.save(personnel);

    }
    @ApiOperation("删除人员")
    @GetMapping("/delete")
    public boolean delete(int PersonnelId){

        return personnelService.removeById(PersonnelId);
    }
    @ApiOperation("修改人员")
    @PostMapping("/change")
    public boolean change(@RequestBody Personnel personnel){

        return personnelService.updateById(personnel);
    }
    @ApiOperation("查看某一个人员")
    @PostMapping("/select")
    public List<Personnel>select(@RequestBody Personnel personnel){

        LambdaQueryWrapper<Personnel>lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Personnel::getPersonnelId,personnel.getPersonnelId());
        return personnelService.list(lambdaQueryWrapper);
    }

}
