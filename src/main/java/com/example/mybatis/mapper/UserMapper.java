package com.example.mybatis.mapper;

import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> findAll();


    User getById(int userId);

    User getUserName(String username);
}