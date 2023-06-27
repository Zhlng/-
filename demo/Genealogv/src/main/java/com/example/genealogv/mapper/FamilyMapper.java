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



    }

