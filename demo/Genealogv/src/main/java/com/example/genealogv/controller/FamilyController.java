package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Family;
import com.example.genealogv.entity.User;
import com.example.genealogv.mapper.FamilyMapper;
import com.example.genealogv.mapper.UserMapper;
import com.example.genealogv.service.FamilyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@Api("家族管理")
@RequestMapping("/family")
public class FamilyController {
@Autowired
    private FamilyService familyService;
@GetMapping("/list")
public List<Family> list(){

    return familyService.list();

}
@PostMapping("/save")
    public boolean save(@RequestBody Family family){

    return familyService.save(family);
}
@GetMapping("/delete")
    public boolean delete(String FamilyId){

    return familyService.removeById(FamilyId);
}
@PostMapping("/change")
    public boolean change(@RequestBody Family family){

    return familyService.updateById(family);
}
@PostMapping("/select")
    public List<Family> select(@RequestBody Family family){
    LambdaQueryWrapper<Family>lambdaQueryWrapper=new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(Family::getFamilyId,family.getFamilyId());
    return familyService.list(lambdaQueryWrapper);
}

}
