package com.peixin.sevice;

import com.peixin.exception.MyException;
import com.peixin.sevice.impl.DemoService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DemoServiceImpl implements DemoService {

    @Override
    public void show1() {
        System.out.println("抛出类型转换异常");
        Object str = "zhangsan";
        Integer num = (Integer) str;

    }

    @Override
    public void show2() {
        System.out.println("抛出除0异常");
        int i = 1 / 0;
    }

    @Override
    public void show3() throws FileNotFoundException {
        System.out.println("抛出文件找不到异常");
        FileInputStream in = new FileInputStream("c:/xxx/xxx.txt");
    }

    @Override
    public void show4() {
        System.out.println("空针针异常");
        String str = null;
        str.length();
    }
    @Override
    public  void  show5() throws MyException{
        System.out.println("自定义异常");
        throw new MyException();
    }

}
