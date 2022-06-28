package com.peixin.interceptor;

import com.peixin.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //判断用户是否登录  本质：判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user==null){
            //没有登录，重定向到目标资源
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }

        //放行，访问目标资源
        return true;
    }

}
