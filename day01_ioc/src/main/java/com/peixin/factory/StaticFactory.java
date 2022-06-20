package com.peixin.factory;

import com.peixin.dao.UserDao;
import com.peixin.dao.impl.UserDaoImpl;

//创建对象工厂
public class StaticFactory {
    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
