package com.peixin.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;

//标志该类是spring核心配置类
@Configuration

//<context:component-scan base-package="com.peixin"/>
//替代组件扫描
@ComponentScan("com.peixin")

//再把分的DataSourceConfiguration加载进来
//<import resource=""/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {


}
