package com.chen.bigwork.service;

import com.chen.bigwork.dao.UserMapper;
import com.chen.bigwork.entities.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Map<String,Object> login(String account,String password){
        Map<String ,Object> map=new HashMap<>();
        if (StringUtils.isBlank(account)) {
            map.put("accountMsg","账号不能为空");
        }

        if(StringUtils.isBlank(password)){
            map.put("passwordMsg","密码不能为空");
            return map;
        }

        User user=userMapper.selectByAccount(account);
        if (user==null){
            map.put("accountMsg","用户不存在");
            return map;
        }
        if(!password.equals(user.getPassword())){
            map.put("passwordMsg","密码错误");
            return map;
        }
        return map;
    }

    public User findUserByAccount(String account ){
        return userMapper.selectByAccount(account);
    }

    public List<User> findAllUser(){
        return userMapper.selectAllUser();
    }
}
