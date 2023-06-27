package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Set;

@Data
//家族表
public class Family {
    @TableId
    private int FamilyId;
    private int UserId;
    private String FamilyName;
    private String FamilyDescription;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String FamilyDate;

}


