package com.peixin.test;

import com.peixin.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    //测试配置文件中的scope属性
    public void test1() {
        //ApplicationContext-ClassPathXmlApplicationContext
        //只会引用test下的resources下的applicationContext.xml文件
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        UserDao userDao2 = (UserDao) app.getBean("userDao");

        System.out.println(userDao1);
        System.out.println(userDao2);

        ((ClassPathXmlApplicationContext) app).close();
    }
}
