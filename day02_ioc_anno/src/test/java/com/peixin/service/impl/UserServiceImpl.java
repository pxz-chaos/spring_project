package com.peixin.service.impl;

import com.peixin.dao.UserDao;
import com.peixin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// <bean id="userService" class="com.peixin.service.impl.UserServiceImpl">
//@Component("userService")//名字对应id
@Service("userService")
//@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Value("zhangsan")
    private String name;

    @Value("${jdbc.driver}")
    private String driver;

    //  <property name="userDao" ref="userDao"></property>
    @Autowired//自动注入，按照数据类型从Spring容器中进行匹配的
    @Qualifier("userDao")//这个注解是按照id值从容器中进行匹配的，但是主要此处的qualifier注解要结合autowired一起使用。
    // 如果userDao有单个bean这个注解也可以省略。

//    @Resource(name="userDao")//添加这个坐标jakarta.annotation-api才可以使用。作用相当于上面两个注解
    private UserDao userDao;


    @Override
    public void save() {
        System.out.println(name);
        System.out.println(driver);
        userDao.save();
    }

    //有了注解以后，set和get方法可以省略了
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @PostConstruct//构造器之后，也就是初始化方法
    public void init(){
        System.out.println("service对象创建方法");
    }
    @PreDestroy//销毁之前
    public void destroy(){
        System.out.println("service对象销毁");
    }
}
