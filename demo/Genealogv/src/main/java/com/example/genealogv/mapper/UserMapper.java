package com.example.genealogv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.genealogv.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
   /* @Select("SELECT * FROM user where UserId=#{UserId}")
    User selectByUserId(int UserId);

    @Select("SELECT * FROM user")
    @Results({
            @Result(column ="UserId",property = "UserId"),
            @Result(column ="User_Name",property = "UserName"),
            @Result(column ="User_Password",property = "UserPassword"),
            @Result(column ="UserId",property = "families",javaType = List.class,
                    many = @Many(select = "com.example.genealogv.mapper.FamilyMapper.selectByUserId")
            )
    })
    List<User> selectAllUserAndFamilies();*/



}
