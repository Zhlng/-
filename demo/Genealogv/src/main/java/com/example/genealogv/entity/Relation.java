package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

//关系表
@Data
public class Relation {
   private int  PersonnelId1;
   private int  PersonnelId2;
   private String RelationType;

}
