package com.example.genealogv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.genealogv.entity.Family;
import com.example.genealogv.entity.Personnel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonnelMapper extends BaseMapper<Personnel> {

    Personnel getMaxId();

    Personnel getById(int personnelId);

    boolean delete(int personnelId);

    List<Personnel> get(Personnel personnel);

}
