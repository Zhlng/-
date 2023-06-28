package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.io.Serializable;

//事件表
@Data
public class Inccident implements Serializable {
    private int PersonnelId;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String InccidentDate;
    private String InccidentDescription;
    private String InccidentType;
    private String InccidentAttachments;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private int Deleted;


}