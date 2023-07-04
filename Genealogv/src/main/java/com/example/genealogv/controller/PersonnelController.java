package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Family;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.mapper.FamilyMapper;
import com.example.genealogv.mapper.PersonnelMapper;
import com.example.genealogv.service.PersonnelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Api("人员管理")
@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private PersonnelMapper personnelMapper;

    @Autowired
    private FamilyMapper familyMapper;

    @ApiOperation("查看所有人员")
    @GetMapping("/list")
    public List<Personnel>list(){

        return personnelService.list();

    }
    @ApiOperation("插入新人员")
    @PostMapping("/save")
    public boolean save(@RequestBody Personnel personnel){
        personnel.setPersonnelId(personnelService.getMaxId().getPersonnelId()+1);
        return personnelService.save(personnel);

    }
    @ApiOperation("删除人员")
    @RequestMapping("/delete")
    public boolean delete(@RequestBody Personnel personnel){
        return personnelMapper.delete(personnel.getPersonnelId());
    }
    @ApiOperation("修改人员")
    @PostMapping("/change")
    public boolean change(@RequestBody Personnel personnel){

        return personnelService.updateById(personnel);
    }

    @ApiOperation("根据家族ID获取成员")
    @PostMapping("/chat")
    public List<Personnel> chat(@RequestBody Personnel personnel){
        List<Personnel> list = personnelMapper.get(personnel);
        for (int i = 0; i < list.size(); i++) {
            Family family = familyMapper.getById(list.get(i).getFamilyId());
            if(family!=null){
                list.get(i).setFamilyName(family.getFamilyName());
            }
        }
        return list;
    }

    @ApiOperation("查看某一个人员")
    @PostMapping("/select")
    public List<Personnel>select(@RequestBody Personnel personnel){
        LambdaQueryWrapper<Personnel>lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Personnel::getPersonnelName,personnel.getPersonnelName());
        return personnelService.list(lambdaQueryWrapper);
    }

}
