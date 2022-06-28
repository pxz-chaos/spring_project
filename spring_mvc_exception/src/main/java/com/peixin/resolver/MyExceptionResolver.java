package com.peixin.resolver;


import com.peixin.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
自定义异常处理步骤
①、创建异常处理器类实现HandlerExceptionResolver
②、配置异常处理器
③、编写异常页面
④、测试
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    /*
    参数Exception：异常对象
    返回值ModelAndView：跳转到错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof MyException) {
            modelAndView.addObject("info","自定义异常");
        }
        else if (ex instanceof ClassCastException){
            modelAndView.addObject("info","类转化异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
