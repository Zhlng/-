package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

//成员表
@Data
public class Personnel {
@TableId
@TableField("PersonnelId")
    private int PersonnelId;
    private int FamilyId;
    private String PersonnelName;
    private String Sex;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String Brithdate;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String Deathdate;

}