package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.entity.Person;
import org.springframework.stereotype.Component;

@Component
public interface PersonMapper extends BaseMapper<Person> {
}
