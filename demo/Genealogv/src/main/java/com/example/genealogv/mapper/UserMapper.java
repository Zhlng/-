package com.example.genealogv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.genealogv.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{//查询对象

   @Select("select * from User")//寻找你配置的数据库中的数据
    public List<User> find();
    @Insert("insert into User values(#{id},#{name},#{password})")
    public int insert(User user);//int表示插入了几个值
    @Delete("delete from User where id={}")
    public int delete(int id);
    @Update("update User set name=#{name},password=#{password} where id=#{id}")
    public int update(User user);
    @Select("select * from User where id=#{id}")//根据ID查找
    public User findByID(int id);
}
