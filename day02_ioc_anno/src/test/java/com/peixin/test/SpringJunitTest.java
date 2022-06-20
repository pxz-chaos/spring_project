package com.peixin.test;

import com.peixin.config.SpringConfiguration;
import com.peixin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/*
spring集成Junit步骤
①、导入spring集成Junit坐标
②、使用@runwith注解替代原来的运行期
③、使用@ContextConfiguration指定配置文件或配置类
④、使用@Autowired注入需要测试的对象
⑤、创建测试方法进行测试

建议仓库直接去mvnrepository搜，如果数据库什么的都是新版本的直接搜新的用，
其他的如果不是关联版本的直接直接搜id全用新的一般都不会报错
https://mvnrepository.com/
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() {
        userService.save();
    }

    @Test
    public void test2() throws SQLException {

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }

}
