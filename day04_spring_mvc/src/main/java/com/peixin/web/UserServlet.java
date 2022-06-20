package com.peixin.web;

import com.peixin.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
1.1 ApplicationContext应用上下文获取方式
    应用上下文对象是通过new ClasspathXmlApplicationContext(spring配置文件) 方式获取的，但是每次从
容器中获得Bean时都要编写new ClasspathXmlApplicationContext(spring配置文件) ，这样的弊端是配置
文件加载多次，应用上下文对象创建多次。
    在Web项目中，可以使用ServletContextListener监听Web应用的启动，我们可以在Web应用启动时，就加
载Spring的配置文件，创建应用上下文对象ApplicationContext，在将其存储到最大的域servletContext域
中，这样就可以在任意位置从域中获得应用上下文ApplicationContext对象了。
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ApplicationContext app=new  ClassPathXmlApplicationContext("applicationContext.xml");
        ServletContext servletContext = req.getServletContext();

//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        //使用手动获取
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        //使用spring自动获取
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = app.getBean(UserService.class);
        userService.save();
        System.out.println("spring容器创建完毕");

    }
}
