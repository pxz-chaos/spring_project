package com.peixin.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateTest {


    /**
     * 测试JDBCTemplate模板开发步骤
     */
    @Test
    public void test1() throws Exception {
        //设置数据源对象

        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        ds.setUser("root");
        ds.setPassword("0712");


        //创建模板对象
        JdbcTemplate template = new JdbcTemplate();
        //设置数据源对象 知道数据库在哪儿
        template.setDataSource(ds);

        System.out.println("数据库连接成功");

        //执行操作
        int row =template.update("insert  into account values(?,?,?)",null,"tom",300);
        System.out.println(row);
    }

    @Test
    //使用spring框架
    public void test02(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = app.getBean(JdbcTemplate.class);

        //执行操作
        int row =template.update("insert  into account values(?,?,?)",null,"tom",300);
        System.out.println(row);

    }
}
