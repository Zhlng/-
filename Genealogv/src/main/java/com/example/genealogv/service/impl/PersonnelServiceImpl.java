package com.example.genealogv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.genealogv.entity.Personnel;
import com.example.genealogv.mapper.PersonnelMapper;
import com.example.genealogv.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnelServiceImpl extends ServiceImpl<PersonnelMapper, Personnel>implements PersonnelService {

    @Autowired
    PersonnelMapper personnelMapper;

    @Override
    public Personnel getMaxId() {
        return personnelMapper.getMaxId();
    }
}
