package com.peixin.test;

import com.peixin.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JDBCTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 更新
     */
    @Test
    public void testUpdate() {
        String sql = "update account set money=? where username=?";
        int row = jdbcTemplate.update(sql, 5000, "jack");
        System.out.println(row);

    }

    /**
     * 删除
     */
    @Test
    public void testDelete() {
        String sql = "delete from account where username=? ";
        int row = jdbcTemplate.update(sql, "tom");
        System.out.println(row);

    }

    /**
     * 查询单个对象
     */
    @Test
    public void testQueryAll() {
        String sql = "select username,money from account";
        List<Account> queryList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : queryList) {
            System.out.println(account);
        }
    }

    /**
     * 查询单个对象
     */
    @Test
    public void testQuerySingle() {
        String sql = "select *from account where id=?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), 1);
        System.out.println(account);
    }

    /**
     * 查询总记录数
     */
    @Test
    public void testQueryCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

}
