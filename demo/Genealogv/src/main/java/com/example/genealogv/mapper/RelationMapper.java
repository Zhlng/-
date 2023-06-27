package com.example.genealogv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.entity.Relation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RelationMapper extends BaseMapper<Relation>{

}
