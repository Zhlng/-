package com.example.genealogv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.genealogv.entity.Family;

import java.util.List;

public interface FamilyService extends IService<Family> {

    Family getMaxId();

    boolean delete(int familyId);

    Family getById(int familyId);

}
