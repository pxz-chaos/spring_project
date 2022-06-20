package com.peixin.dao.impl;

import com.peixin.dao.UserDao;
import com.peixin.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    private String username;
    private int age;


    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl实现类创建");
    }

    @Override
    public void save() {
        System.out.println("save running...");
        System.out.println(username + "===" + age);
        System.out.println(strList);
        for (Map.Entry<String, User> entry : userMap.entrySet()) {
//            System.out.println("key:"+entry.getKey()+"\tvalue:"+entry.getValue().getName()+"+"+entry.getValue().getAddr());
            System.out.println("key:"+entry.getKey()+"\tvalue:"+entry.getValue());
        }

        System.out.println(properties);
    }

    public void init() {
        System.out.println("初始化方法。。。");
    }

    public void destroy() {
        System.out.println("销毁方法。。。");
    }
}
