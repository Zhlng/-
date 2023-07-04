package com.example.genealogv;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan("com.example.genealogv.mapper")
public class GenealogvApplication {
    public static void main(String[] args) {
        SpringApplication.run(GenealogvApplication.class,args);
    }

}
