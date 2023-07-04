package com.example.genealogv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.genealogv.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserMapper extends BaseMapper<User> {

    User getByNameAndPwd(User user);

}
