package com.peixin.service.impl;

import com.peixin.dao.AccountDao;
import com.peixin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.in(inMan, money);
        int i = 1 / 0;
        accountDao.out(outMan, money);
    }
}
