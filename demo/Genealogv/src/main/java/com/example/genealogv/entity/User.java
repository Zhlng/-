package com.example.genealogv.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

@Data
public class User implements Serializable {
    @TableId("user_id")
    private int UserId;
    private String UserName;
    private String UserPassword;

   /* @TableField(exist = false)//注解在字段在表中不存在
    private List<Family>families;//描述用户的所有家族*/

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private int Deleted;


}

