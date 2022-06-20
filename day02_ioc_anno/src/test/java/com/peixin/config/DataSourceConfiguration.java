package com.peixin.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/*<!--加载外部的properties文件-->
<context:property-placeholder location="classpath:jdbc1.properties"/>*/
@PropertySource("classpath:jdbc1.properties")
public class DataSourceConfiguration {
     /*  <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <!--注入参数采用set的方式-->
        <property name="driverClass" value="${jdbc.driver}"></property>
        <property name="jdbcUrl" value="${jdbc.url}"></property>
        <property name="user" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>

    </bean>
    */
    //替代上面的xml配置

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean("dataSource")//spring会将当前方法的返回值名称以指定名称存储到spring容器中
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //设置连接参数
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);
        ds.setUser(username);
        ds.setPassword(password);
        return ds;
    }
}
