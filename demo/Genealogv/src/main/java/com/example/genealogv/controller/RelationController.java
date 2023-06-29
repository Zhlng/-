package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.entity.Relation;
import com.example.genealogv.service.RelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("关系管理")
@RestController
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;
    @ApiOperation("查看所有关系")
    @GetMapping("/list")
    public List<Relation> list(){

        return relationService.list();

    }
    @ApiOperation("插入新关系")
    @PostMapping("/save")
    public boolean save(@RequestBody Relation relation){
        return relationService.save(relation);
    }
    @ApiOperation("删除关系")
    @GetMapping("/delete")
    public boolean delete(int PersonnelId){
        return relationService.removeById(PersonnelId);
    }
    @ApiOperation("修改关系信息")
    @PostMapping("/change")
    public boolean change(@RequestBody Relation relation){
        return relationService.updateById(relation);
    }
    @ApiOperation("查看某一关系")
    @PostMapping("/select")
    public List<Relation>select(@RequestBody Relation relation){
        LambdaQueryWrapper<Relation>lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Relation::getPersonnelId1,relation.getPersonnelId1());
        lambdaQueryWrapper.eq(Relation::getPersonnelId2,relation.getPersonnelId2());
        return relationService.list(lambdaQueryWrapper);

    }

}
