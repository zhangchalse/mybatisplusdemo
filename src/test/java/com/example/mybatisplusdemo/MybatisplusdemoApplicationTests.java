package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.entity.Person;
import com.example.mybatisplusdemo.entity.User;
import com.example.mybatisplusdemo.mapper.PersonMapper;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MybatisplusdemoApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PersonMapper personMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getUserList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void intserUser() {
        User user = new User();
        user.setName("chalse");
        user.setAge(24);
        user.setEmail("183@163.com.cn");
        Integer count = userMapper.insert(user);
        System.out.println(count);
    }

    @Test
    public void intserPerson() {
        Person person = new Person();
        person.setName("mali");
        person.setAge(22);
        Integer count = personMapper.insert(person);
        System.out.println(count);
    }

    @Test
    public void queryPersonPageList() {
        Page<Person> page = new Page<>(2, 3);
        personMapper.selectPage(page, null);
        System.out.println(page.getCountId());
        System.out.println(page.getCurrent());
        System.out.println(page.getMaxLimit());
        System.out.println(page.getOrders());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void deletePerson() {
        Integer count = personMapper.deleteById(27);
    }

    @Test
    public void batchDeletePerson() {
        int count = personMapper.deleteBatchIds(Arrays.asList(11, 12, 13));
        System.out.println(count);
    }

    @Test
    public void queryPersonList() {
        List<Person> personList = personMapper.selectList(null);
        System.out.println(personList);
    }

    @Test
    public void wrapperQuery() {
//        LambdaQueryWrapper lambdaQueryWrapper = new QueryWrapper().lambda();
//        lambdaQueryWrapper.lt("age", 24);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.lt("age", 24);
        Page<Person> page = new Page<>(1,10);
        personMapper.selectPage(page, queryWrapper.lambda());
        System.out.println(page.getRecords());
    }
}
