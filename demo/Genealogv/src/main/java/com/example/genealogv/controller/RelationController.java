package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.entity.Relation;
import com.example.genealogv.service.RelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("关系管理")
@RestController
@RequestMapping("/relation")
public class RelationController {
    @Autowired(required = false)
    private RelationService relationService;
    public List<Relation> list(){

        return relationService.list();

    }
    @PostMapping("/save")
    public boolean save(@RequestBody Relation relation){
        return relationService.save(relation);
    }
    @GetMapping("/delete")
    public boolean delete(int PersonnelId){
        return relationService.removeById(PersonnelId);
    }
    @PostMapping("/change")
    public boolean change(@RequestBody Relation relation){
        return relationService.updateById(relation);
    }
    @PostMapping("/select")
    public List<Relation>select(@RequestBody Relation relation){
        LambdaQueryWrapper<Relation>lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Relation::getPersonnelId1,relation.getPersonnelId1());
        lambdaQueryWrapper.eq(Relation::getPersonnelId2,relation.getPersonnelId2());
        return relationService.list(lambdaQueryWrapper);

    }

}
