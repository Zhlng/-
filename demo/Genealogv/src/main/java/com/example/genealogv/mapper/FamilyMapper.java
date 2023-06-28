package com.example.genealogv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.genealogv.entity.Family;
import com.example.genealogv.entity.User;
import com.example.genealogv.service.FamilyService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface FamilyMapper extends BaseMapper<Family>{
  /*  @Select("select *from family where UserId=#{UserId}")
    List<Family> selectByUserId(int UserId);
@Select("select *from family")
    @Results({
            @Result(column = "FamilyId",property = "FamilyId"),
            @Result(column = "Family_Name",property = "FamilyName"),
            @Result(column = "Family_Date",property = "FamilyDate"),
            @Result(column = "Family_Description",property = "FamilyDescription"),
            @Result(column = "UserId",property = "user",javaType = List.class,
                   one = @One(select = "com.example.genealogv.mapper.UserMapper.selectByFamilyId")
            )
    })
    List<Family>selectOneFamiliesAndUser();分页查询*/


    }

