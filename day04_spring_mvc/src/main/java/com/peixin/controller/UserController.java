package com.peixin.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peixin.domain.User;
import com.peixin.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
 @RequestMapping可以作用到类上，也可以作用到方法上，一般都加

 3.3 SpringMVC注解解析
@RequestMapping
作用：用于建立请求 URL 和处理请求方法之间的对应关系
位置：
 类上，请求URL 的第一级访问目录。此处不写的话，就相当于应用的根目录
 方法上，请求 URL 的第二级访问目录，与类上的使用@ReqquestMapping标注的一级目录一起组成访问虚拟路径
属性：
 value：用于指定请求的URL。它和path属性的作用是一样的
 method：用于指定请求的方式
 params：用于指定限制请求参数的条件。它支持简单的表达式。要求请求参数的key和value必须和配置的一模一样
例如：
 params = {"accountName"}，表示请求参数必须有accountName
 params = {"moeny!100"}，表示请求参数中money不能是100
 */

@Controller
@RequestMapping("/user")
public class UserController {


    //请求地址http://localhost:8080/user/quickStart,  url直接请求是get请求
    @RequestMapping(value = "/quickStart", method = RequestMethod.GET)
    public String save() {
        System.out.println("controller save running...");
        return "success";
    }

    /**
     * @return 一个视图
     */
    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {

        /*
        Model:模型 作用是封装数据的
        View:视图  作用是展示数据的

         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型
        modelAndView.addObject("username", "zhangsan");

        //设置视图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {

        //设置模型
        modelAndView.addObject("username", "lisi");
        //设置视图
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "王麻子");

        return "success";
    }

    /**
     * 请求数据
     *
     * @param request 请求数据
     * @return返回一个jsp页面+字符串"酷丁鱼"
     */
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "酷丁鱼");
        return "success";
    }

    /*
    在web阶段，客户端访问服务器端，如果想直接回写字符串作为响应体返回的话，只需要使用response.getWriter().print("hello world")即可
    那么在springMvc框架注入response对象，使用response.getWriter().print("hello world")回写数据，此时不需要试图跳转，业务方法返回值为void
     */
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");//防止中文乱码
        response.getWriter().print("<h1>hello world</h1>");

    }

    //采用注解的方式响应数据，告知SpringMVC框架，不进行视图跳转，而是直接进行数据响应
    @RequestMapping(value = "/quick7")
    @ResponseBody
    public String save7() {
        return "hello world";

    }

    //返回json格式
    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"zhangsan\"}";

    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);

        //使用json转化工具将对象转化为json格式字符串再返回
        //那么需要json坐标，即在pom.xml导入坐标

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;


    }


    //期待spring-mvc自动将user转化为json格式的字符串
    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);


        return user;


    }

    //获取请求参数(基本数据类型)
    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);

    }

    //获取POJO类型数据，即封装为javabean
    //controller中的业方法的POJO参数的属性名与请求参数的name一致，参数会自动映射匹配
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);//User{username='zhangsan', age=18}

    }

    //获取数组类型的参数
    //controller中的业方法的数组名称名与请求参数的name一致，参数会自动映射匹配
    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.toString(strs));//http://localhost:8080/user/quick13?strs=111&strs=222&strs=33
        //控制台打印[111, 222, 33]
    }

    //获取集合类型的参数
    //POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称。
    //获取集合参数时，要将参数包装到一个POJO中才可以
    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) {

        System.out.println(vo);
    }

    //获取集合参数时，要将参数包装到一个POJO中才可以
    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody(required = false) List<User> userList) {
        System.out.println(userList);

    }


    //参数绑定注解@requestParam
    //当请求的参数名称与controller的业务方法参数不一致时，就需要通过@requestParam注解来显示绑定
    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "张培新") String username) {
        //http://localhost:8080/user/quick16?username=zhangsan
        //但是访问路径中的形参与username不一致的时候？就会出现找不到的现象
        System.out.println(username);


    }


    //restful风格
    //http://localhost:8080/user/quick17/zhangsan
    @RequestMapping(value = "/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable(value = "name", required = true) String username) {

        System.out.println(username);//zhangsan


    }

    //自定义类型转化器
    /*
        spring-mvc默认已经提供了一些常用的类型转化器，例如客户端提交的字符串转化为int类型的参数设置。
        但是不是所有的数据类型都提供了转化器，没有提供的就需要自定义转化器，例如：日期类型的数据就需要自定义转化器

        自定义类型转化器的开发步骤：
        ①、定义转化器类实现convert接口
        ②、在spring-mvc.xml配置文件中申明转化器
        ③、在<annotation-driven>中引用转化器
     */

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) throws ParseException {
        //http://localhost:8080/user/quick18?date=2022-06-15
        System.out.println(date);

    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        //http://localhost:8080/user/quick19
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

    }

    //获取请求头
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String user_agent) {
        //http://localhost:8080/user/quick20
        System.out.println(user_agent);

    }

    //获取请求头
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) {
        //http://localhost:8080/user/quick21
        System.out.println(jsessionId);

    }

    //文件上传
    /*
    文件上传三要素：
    ①、表单项：type="file"
    ②、表单的提交方式post
    ③、表单的enctype属性时多部分表单形式，及enctype="multipart/form-data"
     */
    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22() {


    }


    /*
    单文件上传步骤：
    ①、导入fileupload和io坐标
    <!--导入文件上传坐标-->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.4</version>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.6</version>
        </dependency>
    ②、在spring-mvc中配置文件上传解析器

 <!--配置文件上传解析器-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!--上传文件的总大小-->
        <property name="maxUploadSize" value="5242800"/>
        <!--上传单个文件的大小-->
        <property name="maxUploadSizePerFile" value="5242800"/>
        <!--上传文件的编码类型-->
        <property name="defaultEncoding" value="UTF-8"/>
    </bean>

    ③、编写文件上传代码

     */
    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile multipartFile) throws IOException {

        System.out.println(username);
        System.out.println(multipartFile);
        //获取文件名称
        String originalFilename = multipartFile.getOriginalFilename();
        //保存文件
        multipartFile.transferTo(new File("f:\\upload\\" + originalFilename));
        System.out.println("tijiao");

    }

    //多文件上传
    @RequestMapping(value = "/quick24")
    @ResponseBody
    public void save24(String username, MultipartFile[] multipartFile) throws IOException {

        System.out.println(username);
        System.out.println(multipartFile);
        for (MultipartFile file : multipartFile) {
            //获取文件名称
            String originalFilename = file.getOriginalFilename();
            //保存文件
            file.transferTo(new File("f:\\upload\\" + originalFilename));

        }


    }


}
