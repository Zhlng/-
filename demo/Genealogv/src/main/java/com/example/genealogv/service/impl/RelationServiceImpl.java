package com.example.genealogv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.genealogv.entity.Relation;
import com.example.genealogv.mapper.RelationMapper;
import com.example.genealogv.service.RelationService;
import org.springframework.stereotype.Service;

@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, Relation> implements RelationService {
}
