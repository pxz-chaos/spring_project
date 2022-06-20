package com.peixin.listener;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
1.2 Spring提供获取应用上下文的工具
上面的分析不用手动实现，Spring提供了一个监听器ContextLoaderListener就是对上述功能的封装，该监
听器内部加载Spring配置文件，创建应用上下文对象，并存储到ServletContext域中，提供了一个客户端工
具WebApplicationContextUtils供使用者获得应用上下文对象。
所以我们需要做的只有两件事：
① 在web.xml中配置ContextLoaderListener监听器（导入spring-web坐标）
② 使用WebApplicationContextUtils获得应用上下文对象ApplicationContext
 */
public class ContextLoaderListener implements ServletContextListener {

    //上下文初始化方法
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //将spring的应用上下文存储到servletContext域中
        ServletContext servletContext = sce.getServletContext();
        //读取web.xml的全局参数
        String configLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(configLocation);


        servletContext.setAttribute("app",app);

    }

    //上下文销毁方法
    @Override
    public void contextDestroyed(ServletContextEvent sce) {


    }
}
