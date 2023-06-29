package com.example.genealogv.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.genealogv.entity.Family;
import com.example.genealogv.entity.User;
import com.example.genealogv.mapper.FamilyMapper;
import com.example.genealogv.mapper.UserMapper;
import com.example.genealogv.service.FamilyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
/*@Autowired
private FamilyMapper familyMapper;
@ApiOperation("查看家族所有信息")
@GetMapping("/findAll")
public List findAll(){List families=familyMapper.selectOneFamiliesAndUser();
    return families;
}
@ApiOperation("根据用户id查看家族信息")
@GetMapping("/family")
public List query(){
    List<Family>list=familyMapper.selectList(null);
    System.out.println(list);
    return list;
}分页*/
@ApiOperation("查看全部家族")
@GetMapping("/list")
public List<Family> list(){

    return familyService.list();

}
@ApiOperation("插入新家族")
@PostMapping("/save")
    public boolean save(@RequestBody Family family){

    return familyService.save(family);
}
@ApiOperation("删除家族")
@GetMapping("/delete")
    public boolean delete(String FamilyId){

    return familyService.removeById(FamilyId);
}
@ApiOperation("修改家族")
@PostMapping("/change")
    public boolean change(@RequestBody Family family){

    return familyService.updateById(family);
}
@ApiOperation("根据ID查看家族")
@PostMapping("/select")
    public List<Family> select(@RequestBody Family family){
    LambdaQueryWrapper<Family>lambdaQueryWrapper=new LambdaQueryWrapper<>();
    lambdaQueryWrapper.eq(Family::getFamilyId,family.getFamilyId());
    return familyService.list(lambdaQueryWrapper);
}

}
