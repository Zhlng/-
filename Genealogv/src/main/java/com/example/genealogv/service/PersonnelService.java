package com.example.genealogv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.genealogv.entity.Personnel;
import org.springframework.stereotype.Repository;


public interface PersonnelService extends IService<Personnel> {
    Personnel getMaxId();

}

