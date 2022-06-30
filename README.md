# spring_project
spring-mvc框架学习跟进

## 1.1 spring 环境搭建步骤

1. 创建工程
2. 导入静态页面(将静态页面存放在webapp包下)
3. 创建包结构(cotroller、service、dao、domain、utlis)
4. 导入数据库脚本(.sql)
5. 创建POJO类
6. 创建配置文件(applicationContext.xml、spring-mvc.xml、jdbc.propreties、log4j.properties)



htttp请求→服务端→controller→service→dao→JdbcTemplate模板查询→数据

→service→controller→存到ModelAndView→转发页面进行展示



controller做的工作有：

1. 服务请求映射@RequestMapping：目的是接收http的请求命令
2. 连接业务层service，找spring要：private XxxService xxxService;
3. 展示页面：创建方法，设置ModelAndView 并返回模型视图

### 拦截器知识要点
1. 创建拦截器类实现HandlerInterceptor接口
2. 在spring-mvc.xml配置拦截器
3. 测试拦截器效果

### springMVC异常处理
#### 异常处理方式
①、配置简单异常处理器SimpleMappingExceptionResolver
②、自定义异常处理器
#### 自定义异常处理步骤
①、创建异常处理器类实现HandlerExceptionResolver
②、配置异常处理器
③、编写异常页面
④、测试异常跳转

## Spring的AOP简介

AOP(Aspect Oriented Programming, AOP)面向切面编程

- aop：面向切面编程
- aop底层实现：基于JDK的动态代理（针对有借口的目标）和基于cglib的动态代理（没有借口的目标类）
- aop的重点概念：
  - Pointcut（切入点）：被增强的方法
  - Advice（通知/增强）：封装增强业务逻辑的方法
  - Aspect（切面）：切点+通知
  - Weaving（织入）：将切点与通知结合的过程


- 开发明确事项：
  - 谁是切点（切点表达式配置）
  - 谁是通知（切面类中的增强方法）
  - 将切点和通知进行织入



#### 基于注解的AOP开发

基于注解的aop开发步骤

1. 创建目标接口和目标类（内部有切点）
2. 创建切面类（内部有增强方法）
3. 将目标类和切面类的对象创建权交给spring
4. 在切面类中使用注解配置织入关系
5. 在配置文件中开启组件扫描和aop的自动代理
6. 测试