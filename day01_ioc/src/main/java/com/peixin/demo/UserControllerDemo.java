package com.peixin.demo;

import com.peixin.service.UserService;
import com.peixin.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserControllerDemo {
    public static void main(String[] args) {
        method1();

    }

    public static void method1() {
        //从容器拿 才能读到xml配置 配置了注入
//        UserService userService = new UserServiceImpl();
//        userService.save();
//从类的根路径加载配置文件，推荐使用
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        //一个容器中含有多个bean标签，那么使用id的方式
//        UserService userService = (UserService) app.getBean("userService");//推荐使用
        //一个容器中含有1个bean标签，那么使用class的方式
        UserService userService = app.getBean(UserService.class);
        userService.save();

    }

    static void method2() {
        //从磁盘路径加载配置文件，配置文件可以在磁盘的任意位置。
        ApplicationContext app = new FileSystemXmlApplicationContext("E:\\spring_project\\day01\\src\\main\\resources\\applicationContext.xml");
    }

    static void method3() {
        //使用注解配置容器时，需要使用此类来创建spring容器。用来读取注解

    }
}
