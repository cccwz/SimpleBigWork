package com.chen.bigwork.controller;

import com.chen.bigwork.entities.User;
import com.chen.bigwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userList")
    public String getAllUser(Model model){
        List<User> userList=userService.findAllUser();
        if (userList==null||userList.isEmpty()){
            model.addAttribute("userList",null);
        }else {
            model.addAttribute("userList",userList);
        }

        return "/userList";
    }
}
