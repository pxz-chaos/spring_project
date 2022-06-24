package com.peixin.controller;

import com.peixin.domain.Role;
import com.peixin.domain.User;
import com.peixin.service.RoleService;
import com.peixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @RequestMapping("/list")
    public ModelAndView list() {
        List<User> userList = userService.list();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        List<Role> roleList = roleService.list();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {

        userService.save(user,roleIds);
        return "redirect:/user/list";
    }


}
