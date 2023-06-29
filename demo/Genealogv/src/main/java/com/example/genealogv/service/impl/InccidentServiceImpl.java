package com.example.genealogv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.genealogv.entity.Inccident;
import com.example.genealogv.mapper.InccidentMapper;
import com.example.genealogv.service.InccidentService;
import org.springframework.stereotype.Service;

@Service
public class InccidentServiceImpl extends ServiceImpl<InccidentMapper, Inccident>implements InccidentService {
}
