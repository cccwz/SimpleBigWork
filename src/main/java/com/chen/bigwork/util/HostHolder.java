package com.chen.bigwork.util;

import com.chen.bigwork.entities.User;
import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private ThreadLocal<User> users=new ThreadLocal<>();

    public void  setUsers(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }
}
