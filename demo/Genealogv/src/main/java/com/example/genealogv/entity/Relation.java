package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//关系表
@Data
public class Relation implements Serializable {
   private int  PersonnelId1;
   private int  PersonnelId2;
   private String RelationType;
   private String Elder;
   @TableField(fill = FieldFill.INSERT)
   private Date logtime;
   @TableLogic
   @TableField(fill = FieldFill.INSERT)
   private int Deleted;

}
