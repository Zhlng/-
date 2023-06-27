package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.service.PersonnelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("人员管理")
@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired(required = false)
    private PersonnelService personnelService;
    @GetMapping("/list")
    public List<Personnel>list(){

        return personnelService.list();

    }
    @PostMapping("/save")
    public boolean save(@RequestBody Personnel personnel){

        return personnelService.save(personnel);

    }
    @GetMapping("/delete")
    public boolean delete(int PersonnelId){

        return personnelService.removeById(PersonnelId);
    }
    @PostMapping("/change")
    public boolean change(@RequestBody Personnel personnel){

        return personnelService.updateById(personnel);
    }
    @PostMapping("/select")
    public List<Personnel>select(@RequestBody Personnel personnel){

        LambdaQueryWrapper<Personnel>lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Personnel::getPersonnelId,personnel.getPersonnelId());
        return personnelService.list(lambdaQueryWrapper);
    }

}
