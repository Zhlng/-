package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

@Data
//家族表
public class Family implements Serializable {
    @TableId
    private int FamilyId;
    private int UserId;
    private String FamilyName;
    private String FamilyDescription;
    @DateTimeFormat(pattern ="yyy-MM-dd")
    private String FamilyDate;

   /* @TableField(exist = false)//表中不存在这个属性
    private User user;*/
   @TableField(fill = FieldFill.INSERT)
   private Date logtime;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private int Deleted;


}


