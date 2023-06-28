package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

//成员表
@Data
public class Personnel implements Serializable {
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
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private int Deleted;


}