package com.chen.bigwork.controller;

import com.chen.bigwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @GetMapping(path = "/login")
    public String login(){
        return "/login";
    }

    @GetMapping(path = "/index")
    public String getMainPage(){
        return "/index";
    }

    @PostMapping("/login")
    public String login(String account, String password,
                        Model model, HttpServletResponse response){

        Map<String, Object> map = userService.login(account, password);
        if (map.isEmpty()){
            Cookie cookie=new Cookie("ticket",account);
            cookie.setPath(contextPath);
            response.addCookie(cookie);
            return "redirect:/index";
        }else {
            model.addAttribute("accountMsg",map.get("accountMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            return "/login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
}
