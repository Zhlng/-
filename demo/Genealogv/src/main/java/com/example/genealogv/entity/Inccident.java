package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

//事件表
@Data
public class Inccident {
    @TableField("PersonnelId")
    private int PersonnelId;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String InccidentDate;
    private String InccidentDescription;
    private String InccidentType;
    private String InccidentAttachments;


}