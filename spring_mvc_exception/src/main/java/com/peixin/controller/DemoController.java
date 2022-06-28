package com.peixin.controller;

import com.peixin.exception.MyException;
import com.peixin.sevice.impl.DemoService;
import com.peixin.sevice.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public String show() throws MyException {
        System.out.println("show running....");
//        demoService.show1();
        demoService.show5();
        return "index";
    }

    public void setDemoService(DemoServiceImpl demoService) {
    }
}
