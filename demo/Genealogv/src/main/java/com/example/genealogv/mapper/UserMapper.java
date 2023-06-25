package com.example.genealogv.mapper;

import com.example.genealogv.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {//查询对象

    @Select("select * from user")//寻找你配置的数据库中的数据
    public List<User> find();
    @Insert("insert into user value('')")
    public List<User> inster();
}
