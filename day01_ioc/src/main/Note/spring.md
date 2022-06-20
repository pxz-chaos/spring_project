# spring的开发步骤

## spring快速入门

①、导入坐标 <br>
②、创建bean-->dao层<br>
即：UserDao接口层配置及其实现类<br>
③、创建applicationContext.xml配置文件<br>
④、在配置文件中进行配置<br>

```java
<!--配置全包名--> 
<bean id="userDao" class="com.peixin.dao.impl.UserDaoImpl"></bean> 
```

⑤、创建ApplicationContext对象getBean

```java
ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
UserDao userDao = (UserDao) app.getBean("userDao");
```

### 3.2 Bean标签范围配置

#### 1）当scope的取值为singleton时

Bean的实例化个数：1个

Bean的实例化时机：当Spring核心文件被加载时，实例化配置的Bean实例

Bean的生命周期：

-  对象创建：当应用加载，创建容器时，对象就被创建了
-  对象运行：只要容器在，对象一直活着
-  对象销毁：当应用卸载，销毁容器时，对象就被销毁了

#### 2）当scope的取值为prototype时

Bean的实例化个数：多个

Bean的实例化时机：当调用getBean()方法时实例化Bean

-  对象创建：当使用对象时，创建新的对象实例
-  对象运行：只要对象在使用中，就一直活着
-  对象销毁：当对象长时间不用时，被 Java 的垃圾回收器回收了