package com.peixin.dao.iml;

import com.peixin.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="userDao" class="com.peixin.dao.iml.UserDaoImpl"/>

//@Component("userDao")//这种配置是配置所有的bean标签
@Repository("userDao")//配置dao层的bean标签，使代码可读性更强，其实是一样的效果哈
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
