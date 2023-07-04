package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.entity.Relation;
import com.example.genealogv.mapper.PersonnelMapper;
import com.example.genealogv.mapper.RelationMapper;
import com.example.genealogv.service.RelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Api("关系管理")
@RestController
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;

    @Autowired
    private RelationMapper relationMapper;

    @Autowired
    private PersonnelMapper personnelMapper;

    @ApiOperation("查看所有关系")
    @GetMapping("/list")
    public List<Relation> list(){
        List<Relation> list = relationService.list();
        for (int i = 0; i < list.size(); i++) {
            Personnel personnel = personnelMapper.getById(list.get(i).getPersonnelId1());
            if(personnel!=null){
                list.get(i).setName1(personnel.getPersonnelName());
            }
            Personnel personnel1 = personnelMapper.getById(list.get(i).getPersonnelId2());
            if(personnel1!=null){
                list.get(i).setName2(personnel1.getPersonnelName());
            }
        }
        return list;

    }
    @ApiOperation("插入新关系")
    @PostMapping("/save")
    public boolean save(@RequestBody Relation relation){
        return relationService.save(relation);
    }
    @ApiOperation("删除关系")
    @RequestMapping("/delete")
    public boolean delete(@RequestBody Relation relation){
        return relationMapper.delete(relation);
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
        if (relation.getPersonnelId1()>0){
            lambdaQueryWrapper.eq(Relation::getPersonnelId1,relation.getPersonnelId1());
        }
        if (relation.getPersonnelId2()>0){
            lambdaQueryWrapper.eq(Relation::getPersonnelId2,relation.getPersonnelId2());
        }
        List<Relation> list = relationService.list(lambdaQueryWrapper);
        for (int i = 0; i < list.size(); i++) {
            Personnel personnel = personnelMapper.getById(list.get(i).getPersonnelId1());
            if(personnel!=null){
                list.get(i).setName1(personnel.getPersonnelName());
            }
            Personnel personnel1 = personnelMapper.getById(list.get(i).getPersonnelId2());
            if(personnel1!=null){
                list.get(i).setName2(personnel1.getPersonnelName());
            }
        }
        return list;
    }

}
