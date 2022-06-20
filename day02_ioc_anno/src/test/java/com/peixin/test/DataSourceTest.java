package com.peixin.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test

    //手动测试c3p0数据源
    public void test1() throws Exception {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //设置连接参数
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        ds.setUser("root");
        ds.setPassword("0712");
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    //手动测试druid数据源
    public void test2() throws Exception {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("0712");
        DruidPooledConnection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();

    }

    @Test
    //手动测试c3p0数据源(加载配置文件的方式)
    public void test3() throws Exception {
       /* //使用类加载器的方式读取配置文件
        Properties prop = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
        prop.load(is);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");*/

        //使用ResourceBundle读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("driver");
        String url = rb.getString("url");
        String username = rb.getString("username");
        String password = rb.getString("password");

        //创建数据源对象，设置参数
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);
        ds.setUser(username);
        ds.setPassword(password);

        //获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        System.out.println("连接成功");
        conn.close();


    }
    @Test
    //使用spring容器的方式测试c3p0数据源
    public void test4() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ComboPooledDataSource ds = app.getBean(ComboPooledDataSource.class);
        ComboPooledDataSource ds  = (ComboPooledDataSource) app.getBean("dataSource");
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
    @Test
    //使用spring容器的方式测试druid数据源
    public void test5() throws Exception {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource ds  = (DruidDataSource) app.getBean("druidDataSource");
        DruidPooledConnection conn = ds.getConnection();
        System.out.println(conn);


    }
}
