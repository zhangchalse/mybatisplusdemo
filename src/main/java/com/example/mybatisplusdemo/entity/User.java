package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    /**
     * DROP TABLE IF EXISTS user;
     *
     * CREATE TABLE user
     * (
     * 	id BIGINT(20) NOT NULL COMMENT '主键ID',
     * 	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
     * 	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
     * 	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
     * 	PRIMARY KEY (id)
     * );
     * */


    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
