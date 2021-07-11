package com.chen.bigwork.controller.interceptor;

import com.chen.bigwork.dao.UserMapper;
import com.chen.bigwork.entities.User;
import com.chen.bigwork.service.UserService;
import com.chen.bigwork.util.CookieUtil;
import com.chen.bigwork.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginTicketInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每次请求发送时，从cookie中取得账号名，并查数据库返回user对象，放入hostHolder中
        String account = CookieUtil.getValue(request, "ticket");
        if (account!=null){
            User user = userService.findUserByAccount(account);
            hostHolder.setUsers(user);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //从hostHolder中取到保存的user对象，并添加到modelandview对象中传给前端
        User user = hostHolder.getUser();
        if (user!=null&&modelAndView!=null){
            modelAndView.addObject("loginUser", user);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //模板渲染完之后清空hostHolder
        hostHolder.clear();
    }
}
