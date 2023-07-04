package com.example.genealogv.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.genealogv.entity.Inccident;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper

public interface InccidentMapper extends BaseMapper<Inccident>{

    boolean delete(Inccident inccident);

}
