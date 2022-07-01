package com.peixin.service.impl;

import com.peixin.dao.AccountDao;
import com.peixin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional//表示这个类的所有方法都采用事务
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    /* <tx:advice id="txAdvice" transaction-manager="transactionManager">

        <!--设置事务的属性信息-->
        <tx:attributes>
            <!--设置哪些方法需要进行事务的控制"*"代表所有-->
            <!-- <tx:method name="transfer" isolation="READ_COMMITTED" propagation="REQUIRED" read-only="false"/>
             <tx:method name="abc" isolation="REPEATABLE_READ" propagation="REQUIRED" read-only="false"/>-->
            <tx:method name="*"/>
        </tx:attributes>
    </tx:advice>*/
    public void transfer(String outMan, String inMan, double money) {
        accountDao.in(inMan, money);
        int i = 1 / 0;
        accountDao.out(outMan, money);
    }

}
