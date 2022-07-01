package com.peixin.dao;

public interface AccountDao {
    void out(String outMan,double money);
    void in(String inMan,double money);
}
