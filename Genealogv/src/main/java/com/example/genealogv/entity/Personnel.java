package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//成员表
@Data
public class Personnel implements Serializable {
    private int PersonnelId;
    private int FamilyId;
    private String PersonnelName;
    private String PersonnelSex;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String PersonnelBrithdate;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String PersonnelDeathdate;
    @TableField(fill = FieldFill.INSERT)
    private Date logtime;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private int Deleted;

    @TableField(exist = false)
    private String familyName;


}