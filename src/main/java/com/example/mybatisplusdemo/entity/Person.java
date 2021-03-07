package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    /**
     * CREATE TABLE IF NOT EXISTS `person`(
     *    `id` INT UNSIGNED AUTO_INCREMENT,
     *    `name` VARCHAR(100) NOT NULL,
     *    `age` INT NOT NULL,
     *    `create_time` DATE,
     *    `update_time` DATE,
     *    PRIMARY KEY ( `id` )
     * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
     * */

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * alter table `person` modify `deleted` INT default 0;
     */
    private Integer deleted;
}
