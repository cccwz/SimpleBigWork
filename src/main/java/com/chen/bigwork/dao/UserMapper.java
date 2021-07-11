package com.chen.bigwork.dao;

import com.chen.bigwork.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectByAccount(String account);

    List<User> selectAllUser();
}
